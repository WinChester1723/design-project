package com.example.design.project.controller;

import com.example.design.project.service.serviceInterface.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/signIn")
@RequiredArgsConstructor
public class SignInController {

    private final UserService userService;

    @GetMapping("/show")
    public String displaySignInPage(){
        return "login";
    }


}
