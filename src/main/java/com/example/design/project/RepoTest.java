package com.example.design.project;

import com.example.design.project.model.UserDto;

import java.util.ArrayList;
import java.util.List;

@Development
public class RepoTest {
    private static RepoTest single_instance = null;
    public List<UserDto> userDTORepo;

    public static RepoTest GetInstance(){
        if(single_instance == null) {
            single_instance = new RepoTest();
            single_instance.userDTORepo = new ArrayList<>();
        }
        return single_instance;
    }
}
