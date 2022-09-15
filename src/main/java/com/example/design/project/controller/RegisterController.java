package com.example.design.project.controller;

import com.example.design.project.model.UserDto;
import com.example.design.project.service.UserServiceImp;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/login")
public class RegisterController {
    private UserServiceImp userServiceImp;

    public RegisterController(UserServiceImp userServiceImp) {
        this.userServiceImp = userServiceImp;
    }

    @GetMapping("/show")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new UserDto());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "login";
        }
        return "redirect:/show";
    }

    @PostMapping("/add")
    public String registerUserAccount(@Valid @ModelAttribute("user") UserDto userDto, BindingResult bindingResult,
                                      RedirectAttributes redirectAttributes) {
        if (userServiceImp.userExists(userDto.getUserEmail())) {
            bindingResult.addError(new FieldError("user", "email", "Email was used"));
        }
        if (userDto.getUserPassword() != null && userDto.getsUserPassword() != null) {
            if (!userDto.getsUserPassword().equals(userDto.getsUserPassword())) {
                bindingResult.addError(new FieldError("user", "rPassword", "Password is not same"));
            }
        }
        if (bindingResult.hasErrors()) {
            return "login";
        } else
            userServiceImp.save(userDto);
        return "redirect:/login/?success";
    }


}
