package com.example.design.project.config;

import com.example.design.project.service.AdminServiceImp;
import com.example.design.project.service.UserServiceImp;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig implements WebMvcConfigurer {

    private UserServiceImp userServiceImp;
    private AdminServiceImp adminServiceImp;
    private CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;

    public WebSecurityConfig(UserServiceImp userServiceImp, AdminServiceImp adminServiceImp,
                             CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler) {
        this.userServiceImp = userServiceImp;
        this.adminServiceImp = adminServiceImp;
        this.customAuthenticationSuccessHandler = customAuthenticationSuccessHandler;
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userServiceImp);
        auth.setPasswordEncoder(bCryptPasswordEncoder());

        return auth;
    }

    public void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(authenticationProvider());
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity)throws Exception{
        httpSecurity.authorizeHttpRequests()
                .antMatchers(
                        "/login/**",
                        "/css/**",
                        "/img/**",
                        "/about/**",
                        "/static/**",
                        "/js/**",
                        "/web/index/**",
                        "/web/**",
                        "/portfolio/**",
                        "/index/**",
                        "/service/**",
                        "/art_gallery/**",
                        "/artist/**",
                        "/blog-details/**",
                        "/contact/**"
                ).permitAll()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/profile/**").hasAnyRole("USER","ADMIN")
                .antMatchers("/index").permitAll()
                .and()
                .formLogin()
                .loginPage("/login").successHandler(customAuthenticationSuccessHandler)
                .permitAll()
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login?logout")
                .clearAuthentication(true)
                .invalidateHttpSession(true);
        httpSecurity.csrf().disable();
        return httpSecurity.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer(){
        return (web)->web.ignoring().antMatchers("/resources/**","/img/**","/css/**","/js/**");
    }

    @Bean
    public MessageSource messageSource(){
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:/locale/messages");
        messageSource.setCacheSeconds(3600);
        return messageSource;
    }

//    @Bean
//    public LocalResolver localResolver(){
//        return new SessionLocaleResolver();//new CookieLocaleResolver();
//    }

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor(){
        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
        localeChangeInterceptor.setParamName("lang");
        return localeChangeInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry
                .addInterceptor(localeChangeInterceptor());
    }
}
