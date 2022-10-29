package com.example.design.project.controller;

import com.example.design.project.RepoTest;
import com.example.design.project.model.UserDto;
import com.example.design.project.service.serviceInterface.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/signUp")
@RequiredArgsConstructor
public class SignUpController {

    List<UserDto> repository = new ArrayList<>();

    private final UserService userService;

    @GetMapping()
    public String displaySignUpPage(){
        return "registration";
    }

    @PostMapping("/process")
    public String signUpProcess(Model model, UserDto userDto){

        var userDTObj = RepoTest.GetInstance().userDTORepo;

        // Check if credentials are valid
        boolean invalidEntrance = false;
        for(var field : userDto.getClass().getDeclaredFields())
            if(field == null && field.getName().equals("userId") && field.getName().equals("roles")){
                invalidEntrance = true;
                break;
            }

        // Check if user exists
        boolean existingEntrance = false;
        for(var currentUserDTO : userDTObj)
            if(currentUserDTO.getUserEmail().equals(userDto.getUserEmail())||
                currentUserDTO.getUserName().equals(userDto.getUserName()))
            {
                existingEntrance = true;
                break;
            }

        if(invalidEntrance || existingEntrance)// Error message
        {
            model.addAttribute("message", "Sorry, you entered bad credentials!");
        }else { // Successfully Registered
            RepoTest.GetInstance().userDTORepo.add(userDto);
            model.addAttribute("message", "Successfully registered!");
        }
        return "registration";
    }


}
