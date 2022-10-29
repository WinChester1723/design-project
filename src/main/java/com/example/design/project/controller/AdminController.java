package com.example.design.project.controller;

import com.example.design.project.model.UpdateUserDto;
import com.example.design.project.model.UserDto;
import com.example.design.project.service.serviceInterface.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;

    @GetMapping()
    public String displayAdmin(){
        return "admin/admin-page";
    }

    @GetMapping("/table")
    public String findAllUsers(Model model){
        List<UserDto> list = userService.findAllUsers();
        model.addAttribute("users",list);
        return "admin/admin-page";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id")Integer id){
        userService.deleteById(id);
        return "redirect:/admin/admin-page";
    }

    @PostMapping("/edit/{id}")
    public String editUser(@PathVariable("id")Integer id, UpdateUserDto updateUserDto, Model model){
        var editUser = userService.updateUser(id, updateUserDto);
        model.addAttribute("editUser",editUser);
        return "redirect:/admin/admin-page";
    }

    @GetMapping("/admin-table")
    public String adminTable(){
        return "/admin/admin-table";
    }
}
