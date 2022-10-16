package com.example.design.project.service.serviceInterface;

import com.example.design.project.dao.entity.UserEntity;
import com.example.design.project.model.UserDto;

import java.util.List;

public interface UserService {
    void save( UserDto userDto);
    Boolean userExists(String email);

    UserDto findByEmail();

    List<UserDto> allUsers();

    List<String> getAllRole();

    UserDto findByUserEmail(String email);

    UserEntity findUserByEmail(String userEmail);

    UserDto findByUserName(String userName);
}
