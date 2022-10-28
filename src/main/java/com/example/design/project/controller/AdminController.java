package com.example.design.project.controller;

import com.example.design.project.dao.entity.UserEntity;
import com.example.design.project.model.AddUserDto;
import com.example.design.project.model.UpdateUserDto;
import com.example.design.project.model.UserDto;
import com.example.design.project.service.serviceInterface.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;

    @GetMapping("/admin-page")
    public String adminPage(){
        return "/admin/index";
    }

    @GetMapping("/all-users")
    public String findAllUsers(Model model){
        var userDto = userService.findAllUsers();
        model.addAttribute("users", userDto);
        return "/admin/index";
    }

    @GetMapping("/registration")
    public String adminRegistration(){
        return "/admin/register";
    }

    @GetMapping("/login")
    public String adminLogin(){
        return "/admin/login";
    }

    @GetMapping("/calendar")
    public String adminCalendar(){
        return "/admin/calendar";
    }

    @GetMapping("/forms")
    public String adminForms(){
        return "/admin/forms";
    }

    @GetMapping("icons")
    public String adminIcons(){
        return "/admin/icons";
    }

    @GetMapping("profile")
    public String adminProfile(){
        return "/admin/profile";
    }

    @GetMapping("reset-password")
    public String adminResetPass(){
        return "/admin/reset-password";
    }

    @GetMapping("tables")
    public String adminTables(){
        return "/admin/tables";
    }

    @PostMapping("/edit-users/{id}")
    public String editUsers(@PathVariable("id") Integer id, Model model, UpdateUserDto updateUserDto){
        var usersDto = userService.updateUser(updateUserDto);
        model.addAttribute("users", usersDto);
        return "edit-users";
    }

    @DeleteMapping("/delete-users/{id}")
    public String deleteUsers(@PathVariable("id")Integer id){
        userService.deleteById(id);
        return "redirect:/admin/admin-page";
    }

}
