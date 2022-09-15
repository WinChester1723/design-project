package com.example.design.project.controller;

import com.example.design.project.service.AdminServiceImp;
import com.example.design.project.service.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/web")
public class WebController {
    private UserServiceImp userServiceImp;
    private AdminServiceImp adminServiceImp;

    public WebController(UserServiceImp userServiceImp, AdminServiceImp adminServiceImp) {
        this.userServiceImp = userServiceImp;
        this.adminServiceImp = adminServiceImp;
    }

    @GetMapping(path = {"/home", "/", "/index"})
    public String index(Model model) {
        model.addAttribute("authoritiesUser", userServiceImp.getAllRole());
        model.addAttribute("authoritiesAdmin", adminServiceImp.getAllRole());
        model.addAttribute("user", userServiceImp.findByEmail());
        return "index";
    }

    @GetMapping("/login")
    public String login(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "login";
        }
        model.addAttribute("user", userServiceImp.findByEmail());
        model.addAttribute("authorities", userServiceImp.getAllRole());
        model.addAttribute("authorities", adminServiceImp.getAllRole());

        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "redirect:/";
        }
        model.addAttribute("user", userServiceImp.findByEmail());
        model.addAttribute("authorities", userServiceImp.getAllRole());
        model.addAttribute("authorities", adminServiceImp.getAllRole());

        return "redirect:login?logout";
    }

    @GetMapping("/about")
    public String about(Model model) {

        return "about";
    }

    @GetMapping("/art-gallery")
    public String artGallery(Model model) {

        return "art_gallery";
    }

    @GetMapping("/artist")
    public String artist(Model model) {

        return "artist";
    }

    @GetMapping("/blog")
    public String blog(Model model) {

        return "blog";
    }

    @GetMapping("/blog-details")
    public String blogDetails(Model model) {

        return "blog-details";
    }

    @GetMapping("/contact")
    public String contact(Model model) {

        return "contact";
    }

    @GetMapping("/portfolio")
    public String portfolio(Model model) {

        return "portfolio";
    }

    @GetMapping("/services")
    public String services(Model model) {

        return "services";
    }

    @GetMapping("/profile")
    public String wishlist() {
        return "profile";
    }
}
