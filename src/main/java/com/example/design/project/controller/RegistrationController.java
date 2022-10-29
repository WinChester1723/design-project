package com.example.design.project.controller;

import com.example.design.project.dao.entity.RoleEntity;
import com.example.design.project.model.UserDto;
import com.example.design.project.model.enums.RoleEnum;
import com.example.design.project.service.serviceInterface.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@Controller
@RequiredArgsConstructor
@RequestMapping("/web")
public class RegistrationController {

    private final UserService userService;

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/registration")
    public String showRegistration() {//Model model

//        model.addAttribute("userDto",new UserDto());
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//
//        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
//            return "registration";
//        }

        return "registration";
    }

    @PostMapping("/add")
    public String registration(@ModelAttribute("userDto") UserDto userDto) {

        userDto.setUserId(0);
        Set<RoleEntity> roleTest = new HashSet<>();
        RoleEntity t1 = new RoleEntity(RoleEnum.ADMIN);
        roleTest.add(t1);
        userDto.setRoles(roleTest);

        //System.out.println(userDto.toString());

        userService.addUser(userDto);
        return "redirect:/registration?success";
    }

    @GetMapping("/access-denied")
    public String showAccessDenied() {

        return "accessDenied";

    }

}
