//package com.example.design.project.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
//import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//public class SecConfig {
//    @Bean
//    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
//        final List<GlobalAuthenticationConfigurerAdapter> configurers = new ArrayList<>();
//        configurers.add(new GlobalAuthenticationConfigurerAdapter() {
//                            @Override
//                            public void configure(AuthenticationManagerBuilder auth) throws Exception {
//                                // auth.doSomething()
//                            }
//                        }
//        );
//        return authConfig.getAuthenticationManager();
//    }
//
//}
