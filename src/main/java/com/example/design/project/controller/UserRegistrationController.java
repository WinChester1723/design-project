package com.example.design.project.controller;

import com.example.design.project.model.UserDto;
import com.example.design.project.service.UserService;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {
    private UserService userService;

    public UserRegistrationController(UserService userService) {
        this.userService = userService;
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new UserDto());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "registration";
        }
        return "redirect:/";
    }

    @PostMapping("/add")
    public String registerUserAccount(@Valid @ModelAttribute("user") UserDto customerRegistrationDto,
                                      BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (userService.userExists(customerRegistrationDto.getUserEmail())) {
            bindingResult.addError(new FieldError("user", "email", "Email was used"));
        }
        if (customerRegistrationDto.getsUserPassword() != null && customerRegistrationDto.getrPassword() != null) {
            if (!customerRegistrationDto.getUserPassword().equals(customerRegistrationDto.getrPassword())) {
                bindingResult.addError(new FieldError("user", "rPassword", "Password is not avialable"));
            }
        }
        if (bindingResult.hasErrors()) {
            return "registration";
        } else
            userService.save(customerRegistrationDto);
        return "redirect:registration/?success";
    }
}
