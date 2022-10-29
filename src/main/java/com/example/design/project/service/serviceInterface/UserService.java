package com.example.design.project.service.serviceInterface;

import com.example.design.project.dao.entity.UserEntity;
import com.example.design.project.model.AddUserDto;
import com.example.design.project.model.UpdateUserDto;
import com.example.design.project.model.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.transaction.Transactional;
import java.util.List;

public interface UserService extends UserDetailsService {
    UserDto addUser(AddUserDto userDto);
    UserDto addAdmin(AddUserDto userDto);
    List<String> getAllRole();
    UserDto findByUserEmail(String email);
//    UserDto findUserByEmail(String userEmail);
    UserDto findByUserName(String userName);

    UserDto updateUser(Integer id, UpdateUserDto updateUserDto);
    UserDto findById(int id);
    List<UserDto> findAllUsers();
    List<UserDto> findAllAdmins();
    void deleteById(int id);
}
