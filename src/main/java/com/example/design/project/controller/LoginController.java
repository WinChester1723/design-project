package com.example.design.project.controller;

import com.example.design.project.service.serviceImplements.SecurityServiceImp;
import com.example.design.project.service.serviceImplements.UserServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/web")
@RequiredArgsConstructor
public class LoginController {
    private UserServiceImp userServiceImp;
    private SecurityServiceImp securityServiceImp;


//    @GetMapping("/login")
//    public String login(Model model) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//
//        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
//            return "login";
//        }
//        model.addAttribute("user", userServiceImp.findByEmail());
//        model.addAttribute("authorities", userServiceImp.getAllRole());
//        model.addAttribute("authorities", adminServiceImp.getAllRole());
//
//        return "redirect:/";
//    }

    @GetMapping("/login")
    public String login(Model model, String error, String logout){
        if (securityServiceImp.isAuthenticated()) {
            return "redirect:/";
        }

        if (error != null) {
            model.addAttribute("error", "Invalid username or password,please verify your credentials.");
        }

        if (logout != null)
            model.addAttribute("message", "Login successful.");

        return "login";
    }

    @GetMapping("/logout")
    public String logout(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "redirect:/";
        }
        model.addAttribute("user", userServiceImp.findByEmail());
        model.addAttribute("authorities", userServiceImp.getAllRole());

        return "redirect:login?logout";
    }
}
