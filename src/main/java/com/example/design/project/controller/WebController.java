package com.example.design.project.controller;

import com.example.design.project.service.AdminServiceImp;
import com.example.design.project.service.UserService;
import com.example.design.project.service.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping(path = {"/home","/"})
    public String index(Model model){
        model.addAttribute("authoritiesUser",userServiceImp.getAllRole());
        model.addAttribute("authoritiesAdmin",adminServiceImp.getAllRole());
        model.addAttribute("user",userServiceImp.findByEmail());
        return "redirect:/";
    }


}
