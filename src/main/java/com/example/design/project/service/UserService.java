package com.example.design.project.service;

import com.example.design.project.model.UserDto;
import org.springframework.stereotype.Service;

public interface UserService {
    public void save( UserDto userDto);
    public Boolean userExists(String email);
}
