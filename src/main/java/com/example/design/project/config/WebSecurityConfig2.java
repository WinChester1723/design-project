//package com.example.design.project.config;
//
//import com.example.design.project.service.serviceImplements.AdminServiceImp;
//import com.example.design.project.service.serviceImplements.UserServiceImp;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//
//public class WebSecurityConfig2 extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    private UserServiceImp userServiceImp;
//    @Autowired
//    private AdminServiceImp adminServiceImp;
//    @Autowired
//    private CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;
//
//    @Bean
//    public BCryptPasswordEncoder bCryptPasswordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable().authorizeRequests()
//                .antMatchers("/login/**",
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
//                        "/contact/**").permitAll()
//
//                .antMatchers("/profile/**").hasAnyRole("USER","ADMIN")
//                .antMatchers("/admin/**").hasRole("ADMIN")
//                .antMatchers("/index").permitAll()
//                .and()
//                .formLogin()
//                .loginPage("/login")
//                .loginProcessingUrl("/authenticateTheUser")
//                .successHandler(customAuthenticationSuccessHandler)
//                .permitAll()
//                .and()
//                .logout()
//                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//                .logoutSuccessUrl("/login?logout")
//                .permitAll()
//                .and()
//                .exceptionHandling().accessDeniedPage("/access-denied");
//
//    }
//
////    @Bean
////    public AuthenticationManager customAuthenticationManager() throws Exception {
////        return authenticationManager();
////    }
//
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.authenticationProvider(authenticationProvider());
//    }
//
//    public DaoAuthenticationProvider authenticationProvider() {
//        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
//        auth.setUserDetailsService(userServiceImp);
//        auth.setPasswordEncoder(bCryptPasswordEncoder());
//
//        return auth;
//    }
//
//    @Bean
//    public WebSecurityCustomizer webSecurityCustomizer(){
//        return (web)->web.ignoring().antMatchers("/resources/**","/img/**","/css/**","/js/**");
//    }
//}
