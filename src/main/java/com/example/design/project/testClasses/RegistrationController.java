//package com.example.design.project.controller;
//
//import com.example.design.project.model.UserDto;
//import com.example.design.project.service.serviceInterface.UserService;
//import org.springframework.beans.propertyeditors.StringTrimmerEditor;
//import org.springframework.security.authentication.AnonymousAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.validation.FieldError;
//import org.springframework.web.bind.WebDataBinder;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//import java.util.List;
//
//@Controller
//@RequestMapping("/registration")
//public class RegistrationController {
//    private UserService userService;
//
//    public RegistrationController(UserService userService) {
//        this.userService = userService;
//    }
//
//    @InitBinder
//    public void initBinder(WebDataBinder dataBinder) {
//        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
//        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
//    }
//
//    @GetMapping("/")
//    public String showRegistrationForm(Model model) {
//        model.addAttribute("user", new UserDto());
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//
//        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
//            return "registration";
//        }
//        return "redirect:/";
//    }
//
//    @PostMapping("/add")
//    public String registerUserAccount(@Valid @ModelAttribute("user") UserDto userDto,
//                                      BindingResult bindingResult, Model model) {
//
//        var existingUser = userService.findUserByEmail(userDto.getUserEmail());
//
//        if (userService.userExists(userDto.getUserEmail())) {
//            bindingResult.addError(new FieldError("user", "email", "Email was used"));
//        }
//        //this snippet i will comment
//        if (userDto.getsUserPassword() != null && userDto.getrPassword() != null) {
//            if (!userDto.getUserPassword().equals(userDto.getrPassword())) {
//                bindingResult.addError(new FieldError("user", "rPassword", "Password is not avialable"));
//            }
//        }
//        if (bindingResult.hasErrors()) {
//            model.addAttribute("user", userDto);
//            return "registration";
//        } else
//            userService.save(userDto);
//        return "redirect:/registration?success";
//    }
//
//    @GetMapping("/users")
//    public String users(Model model){
//        List<UserDto> list = userService.allUsers();
//        model.addAttribute("users", list);
//        return "users";
//    }
//}
