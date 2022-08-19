package com.example.design.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/web")
public class TestController {

    @GetMapping("/index")
    public String index(){
        return "index";
    }

    @GetMapping("/about")
    public String about(){
        return "about";
    }

    @GetMapping("/blog")
    public String blog(){
        return "blog";
    }

    @GetMapping("/contact")
    public String contact(){
        return "contact";
    }

    @GetMapping("/portfolio")
    public String portfolio(){
        return "portfolio";
    }

    @GetMapping("/services")
    public String service(){
        return "services";
    }

    @GetMapping("/blog-details")
    public String blogDetails(){
        return "blog-details";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }


    @GetMapping("/test")
    public String test(){
        return "test";
    }

}
