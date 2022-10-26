package com.example.design.project.config;

import com.example.design.project.model.enums.RoleEnum;
import com.example.design.project.service.serviceInterface.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
        private final UserService userService;
        private final CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable().authorizeHttpRequests()
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
                .antMatchers("/admin/**").hasRole(RoleEnum.ADMIN.name())
                .antMatchers("/profile/**").hasAnyRole(RoleEnum.USER.name(),RoleEnum.ADMIN.name())
                .antMatchers("/index").permitAll()
                .and()
                .formLogin()
                .loginPage("/login")
                .successHandler(customAuthenticationSuccessHandler)
                .permitAll()
                .and()
                .logout()
                .logoutSuccessUrl("/login?logout")
                .clearAuthentication(true)
                .invalidateHttpSession(true)
                .and().exceptionHandling().accessDeniedPage("/access-denied");
    }

    @Bean
    public AuthenticationManager customAuthenticationManager() throws Exception {
        return authenticationManager();
    }

    @Override
    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception{
        authenticationManagerBuilder.userDetailsService(userService).passwordEncoder(bCryptPasswordEncoder());
    }

}
