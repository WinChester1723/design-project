package com.example.design.project.controller;

import com.example.design.project.Development;
import com.example.design.project.RepoTest;
import com.example.design.project.model.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashSet;

@Development
@Deprecated

@Controller
@RequestMapping("/admin_panel")
public class AdminPanelController {

    @Deprecated
    private static boolean addFalseData = true;

    @GetMapping()
    public String displaySignInPage(Model model) {

        // automatically display data when the page's loaded
        var userDTObj = RepoTest.GetInstance().userDTORepo;
        model.addAttribute("userDTOs", userDTObj);

        // populate fake data
        if (addFalseData) {
            addFalseData = false;

            RepoTest.GetInstance().userDTORepo.add(new UserDto(0, "Orkhan", "Aliyev", "OrkhanGG",
                    "orxan.eliyev.orxan@gmail.com", "OrxanEliyev00", new HashSet<>()));
            RepoTest.GetInstance().userDTORepo.add(new UserDto(1, "Shamil", "Sariyev", "Shamil",
                    "shamil.valiyev.shamil@gmail.com", "Shamil00", new HashSet<>()));
        }

        return "admin_panel";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String onDeleteDto(Model model, @ModelAttribute(value = "userDTOToDelete") UserDto userDto) {

        // userEmail is used for validation
        if (userDto != null)
            for (int c = 0; c < RepoTest.GetInstance().userDTORepo.size(); c++) {
                UserDto i = RepoTest.GetInstance().userDTORepo.get(c);
                if (i.getUserEmail().equals(userDto.getUserEmail())) {
                    RepoTest.GetInstance().userDTORepo.remove(c);
                    break;
                }
            }

        // automatically display data when the page's loaded
        var userDTObj = RepoTest.GetInstance().userDTORepo;
        model.addAttribute("userDTOs", userDTObj);

        return "admin_panel";
    }
}
