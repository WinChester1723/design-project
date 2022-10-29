package com.example.design.project.controller;

import com.example.design.project.model.UserDto;
import com.example.design.project.service.serviceInterface.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/signUp")
@RequiredArgsConstructor
public class SignUpController {

    private final UserService userService;

    @GetMapping("/show")
    public String displaySignUpPage(){
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

        return "registration";
    }


}
