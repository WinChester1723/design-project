package com.example.design.project.controller;

import com.example.design.project.RepoTest;
import com.example.design.project.model.UserDto;
import com.example.design.project.service.serviceInterface.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/signIn")
@RequiredArgsConstructor
public class SignInController {

    private final UserService userService;

    @GetMapping()
    public String displaySignInPage(){
        return "login";
    }


    @RequestMapping(value="/process",method = RequestMethod.POST)
    public String proceedSignIn(Model model, @ModelAttribute("userDTO") UserDto userDto){

        var userDTObj = RepoTest.GetInstance().userDTORepo;

        // Check if user exists
        boolean existingEntrance = false;
        for(var currentUserDTO : userDTObj)
            if(currentUserDTO.getUserEmail().equals(userDto.getUserEmail())||
                    currentUserDTO.getUserName().equals(userDto.getUserName()))
            {
                existingEntrance = true;
                break;
            }

        if(existingEntrance)
        {
            model.addAttribute("message", "You have successfully signed in!");
        }else { // Successfully Registered
            model.addAttribute("message", "Bad Credentials!");
        }

        return "inform_user";
    }


}
