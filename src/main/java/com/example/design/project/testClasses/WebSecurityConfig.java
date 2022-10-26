//package com.example.design.project.config;
//
//import com.example.design.project.model.enums.RoleEnum;
//import com.example.design.project.service.serviceInterface.UserService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
//
//@Configuration
//@EnableWebSecurity
//@RequiredArgsConstructor
//public class WebSecurityConfig implements WebMvcConfigurer {
//
//    private UserService userService;
//    private CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;
//
//
//    @Bean
//    public BCryptPasswordEncoder bCryptPasswordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public DaoAuthenticationProvider authenticationProvider() {
//        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
//        auth.setUserDetailsService(userService);
//        auth.setPasswordEncoder(bCryptPasswordEncoder());
//        return auth;
//    }
//
//    public void configure(AuthenticationManagerBuilder auth) {
//        auth.authenticationProvider(authenticationProvider());
//    }
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity httpSecurity)throws Exception{
//        httpSecurity.authorizeHttpRequests()
//                .antMatchers(
//                        "/login/**",
//                        "/css/**",
//                        "/img/**",
//                        "/about/**",
//                        "/static/**",
//                        "/js/**",
//                        "/web/index/**",
//                        "/web/**",
//                        "/portfolio/**",
//                        "/index/**",
//                        "/service/**",
//                        "/art_gallery/**",
//                        "/artist/**",
//                        "/blog-details/**",
//                        "/contact/**"
//                ).permitAll()
//                .antMatchers("/admin/**").hasRole(RoleEnum.ADMIN.name())
//                .antMatchers("/profile/**").hasAnyRole(RoleEnum.USER.name(),RoleEnum.ADMIN.name())
//                .antMatchers("/index").permitAll()
//                .and()
//                .formLogin()
//                .loginPage("/login")
//                .successHandler(customAuthenticationSuccessHandler)
//                .permitAll()
//                .and()
//                .logout()
//                .logoutSuccessUrl("/login?logout")
//                .clearAuthentication(true)
//                .invalidateHttpSession(true);
//        httpSecurity.csrf().disable();
//        return httpSecurity.build();
//    }
//
//        @Bean
//        public WebSecurityCustomizer webSecurityCustomizer(){
//            return (web)->web.ignoring().antMatchers("/resources/**","/img/**","/css/**","/js/**");
//        }
//
////    @Bean
////    public MessageSource messageSource(){
////        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
////        messageSource.setBasename("classpath:/locale/messages");
////        messageSource.setCacheSeconds(3600);
////        return messageSource;
////    }
//
////    @Bean
////    public LocalResolver localResolver(){
////        return new SessionLocaleResolver();//new CookieLocaleResolver();
////    }
//
//    @Bean
//    public LocaleChangeInterceptor localeChangeInterceptor(){
//        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
//        localeChangeInterceptor.setParamName("lang");
//        return localeChangeInterceptor;
//    }
//
////    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry
//                .addInterceptor(localeChangeInterceptor());
//    }
//}
