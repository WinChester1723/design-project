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

    @GetMapping(path = {"/home","/","/index"})
    public String index(Model model){
        model.addAttribute("authoritiesUser",userServiceImp.getAllRole());
        model.addAttribute("authoritiesAdmin",adminServiceImp.getAllRole());
        model.addAttribute("user",userServiceImp.findByEmail());
        return "index";
    }

    @GetMapping("/login")
    public String login(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || authentication instanceof AnonymousAuthenticationToken){
            return "login";
        }
        model.addAttribute("user",userServiceImp.findByEmail());
        model.addAttribute("authorities", userServiceImp.getAllRole());
        model.addAttribute("authorities", adminServiceImp.getAllRole());

        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || authentication instanceof AnonymousAuthenticationToken){
            return "redirect:/";
        }
        model.addAttribute("user",userServiceImp.findByEmail());
        model.addAttribute("authorities",userServiceImp.getAllRole());
        model.addAttribute("authorities", adminServiceImp.getAllRole());

        return "redirect:login?logout";
    }

    @GetMapping("/about")
    public String about(Model model) {
//        model.addAttribute("authorities", userServiceImp.allUsers());
//        model.addAttribute("user", userServiceImp.findByEmail());
//        model.addAttribute("authorities", userServiceImp.getAllRole());
//        model.addAttribute("authorities", adminServiceImp.allAdmins());
//        model.addAttribute("authorities", adminServiceImp.getAllRole());

        return "about";
    }

    @GetMapping("/art-gallery")
    public String artGallery(Model model) {
//        model.addAttribute("authorities", userServiceImp.allUsers());
//        model.addAttribute("user", userServiceImp.findByEmail());
//        model.addAttribute("authorities", userServiceImp.getAllRole());
//        model.addAttribute("authorities", adminServiceImp.allAdmins());
//        model.addAttribute("authorities", adminServiceImp.getAllRole());

        return "art_gallery";
    }

    @GetMapping("/artist")
    public String artist(Model model) {
//        model.addAttribute("authorities", userServiceImp.allUsers());
//        model.addAttribute("user", userServiceImp.findByEmail());
//        model.addAttribute("authorities", userServiceImp.getAllRole());
//        model.addAttribute("authorities", adminServiceImp.allAdmins());
//        model.addAttribute("authorities", adminServiceImp.getAllRole());

        return "artist";
    }

    @GetMapping("/blog")
    public String blog(Model model) {
//        model.addAttribute("authorities", userServiceImp.allUsers());
//        model.addAttribute("user", userServiceImp.findByEmail());
//        model.addAttribute("authorities", userServiceImp.getAllRole());
//        model.addAttribute("authorities", adminServiceImp.allAdmins());
//        model.addAttribute("authorities", adminServiceImp.getAllRole());

        return "blog";
    }

    @GetMapping("/blog-datails")
    public String blogDetails(Model model) {
//        model.addAttribute("authorities", userServiceImp.allUsers());
//        model.addAttribute("user", userServiceImp.findByEmail());
//        model.addAttribute("authorities", userServiceImp.getAllRole());
//        model.addAttribute("authorities", adminServiceImp.allAdmins());
//        model.addAttribute("authorities", adminServiceImp.getAllRole());

        return "blog-details";
    }

    @GetMapping("/contact")
    public String contact(Model model) {
//        model.addAttribute("authorities", userServiceImp.allUsers());
//        model.addAttribute("user", userServiceImp.findByEmail());
//        model.addAttribute("authorities", userServiceImp.getAllRole());
//        model.addAttribute("authorities", adminServiceImp.allAdmins());
//        model.addAttribute("authorities", adminServiceImp.getAllRole());

        return "contact";
    }

    @GetMapping("/portfolio")
    public String portfolio(Model model) {
//        model.addAttribute("authorities", userServiceImp.allUsers());
//        model.addAttribute("user", userServiceImp.findByEmail());
//        model.addAttribute("authorities", userServiceImp.getAllRole());
//        model.addAttribute("authorities", adminServiceImp.allAdmins());
//        model.addAttribute("authorities", adminServiceImp.getAllRole());

        return "portfolio";
    }

    @GetMapping("/services")
    public String services(Model model) {
//        model.addAttribute("authorities", userServiceImp.allUsers());
//        model.addAttribute("user", userServiceImp.findByEmail());
//        model.addAttribute("authorities", userServiceImp.getAllRole());
//        model.addAttribute("authorities", adminServiceImp.allAdmins());
//        model.addAttribute("authorities", adminServiceImp.getAllRole());

        return "services";
    }

    @GetMapping("/profile")
    public String wishlist(){
        return "profile";
    }
}
