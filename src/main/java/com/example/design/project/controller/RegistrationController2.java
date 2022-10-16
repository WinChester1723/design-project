package com.example.design.project.controller;

import com.example.design.project.model.UserDto;
import com.example.design.project.service.serviceImplements.SecurityServiceImp;
import com.example.design.project.service.serviceImplements.UserServiceImp;
import com.example.design.project.validator.UserValidator;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/registration")
public class RegistrationController2 {

    private UserServiceImp userServiceImp;
    private UserValidator userValidator;
    private SecurityServiceImp securityServiceImp;

    public RegistrationController2(UserServiceImp userServiceImp, UserValidator userValidator,
                                   SecurityServiceImp securityServiceImp) {
        this.userServiceImp = userServiceImp;
        this.userValidator = userValidator;
        this.securityServiceImp = securityServiceImp;
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/")
    public String showRegistration(Model model) {
        if (securityServiceImp.isAuthenticated()) {
            return "redirect:/";
        }
        model.addAttribute("userForm", new UserDto());
        return "registration";
    }

    @PostMapping("/add")
    public String registration(@ModelAttribute("userForm") UserDto userForm, BindingResult bindingResult) {
        userValidator.validate(userForm, bindingResult);
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        userServiceImp.save(userForm);
        securityServiceImp.autoLogin(userForm.getUserName(), userForm.getUserPassword());
        return "redirect:/";
    }

    @GetMapping("/access-denied")
    public String showAccessDenied() {

        return "accessDenied";

    }

}
