package com.example.design.project.controller;

import com.example.design.project.service.serviceImplements.UserServiceImp;
import com.example.design.project.service.serviceInterface.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/web")
@RequiredArgsConstructor
public class WebController {
    private UserService userService;


    @GetMapping(path = {"/home", "/", "/index"})
    public String index(Model model) {
        model.addAttribute("authoritiesUser", userService.getAllRole());
        model.addAttribute("user", userService.findByEmail());
        return "index";
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
