package com.example.design.project.service;

import com.example.design.project.model.UserDto;

import java.util.List;

public interface UserService {
    void save( UserDto userDto);
    Boolean userExists(String email);

    UserDto findByEmail(String email);

    List<UserDto> allUsers();

    List<String> getAllRole();
}
