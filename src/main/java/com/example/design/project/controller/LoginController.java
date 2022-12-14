package com.example.design.project.controller;

import com.example.design.project.model.UserDto;
import com.example.design.project.model.enums.ErrorMessageEnum;
import com.example.design.project.service.serviceInterface.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/web")
@RequiredArgsConstructor
@Deprecated
public class LoginController {
    private UserService userService;

    @GetMapping("/login")
    public String login() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//
//        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
//            return "login";
//        }
//        if (error != null) {
//            model.addAttribute("error", ErrorMessageEnum.INVALID_USER.getMessage());
//        }
//        if (logout != null) {
//            model.addAttribute("logout", "Login successful.");
//        }
//
//        model.addAttribute("userDto", userService.findByUserEmail(userDto.getUserEmail()));
//        model.addAttribute("authorities", userService.getAllRole());

        return "login";
    }

    @PostMapping("/login/signIn")
    public String signIn(Model model, UserDto userDto, String error, String logout) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            System.err.println("---------Unauthorized attempt with wrong credentials!------");
            return "login";
        }
        if (error != null || !error.isBlank()) {
            model.addAttribute("error", ErrorMessageEnum.INVALID_USER.getMessage());
        }

        // TODO: fix this later
        if (logout != null) {
            model.addAttribute("logout", "Login successful.");
        }

        for(var field : userDto.getClass().getDeclaredFields())
            if(field == null)
                System.err.println("One of DTO fields were null while logging in! Field name:"+field.getName());

        model.addAttribute("userDto", userService.findByUserEmail(userDto.getUserEmail()));
        model.addAttribute("authorities", userService.getAllRole());

        return "redirect:login";
    }

    @GetMapping("/logout")
    public String logout(Model model, UserDto userDto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "redirect:/";
        }

        model.addAttribute("userDto", userService.findByUserEmail(userDto.getUserEmail()));
        model.addAttribute("authorities", userService.getAllRole());

        return "redirect:login?logout";
    }
}
