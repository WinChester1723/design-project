package com.example.design.project.service;

import com.example.design.project.dao.entity.RoleEntity;
import com.example.design.project.dao.entity.UserEntity;
import com.example.design.project.dao.repository.UserRepo;
import com.example.design.project.model.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;

@Service
public class UserServiceImp implements UserService,UserDetailsService {
    private UserRepo userRepo;

    public UserServiceImp(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    @Transactional
    public void save( UserDto userDto) {
        UserEntity userEntity = new UserEntity(userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getUserName(),
                userDto.getUserEmail(),
                new BCryptPasswordEncoder().encode(userDto.getUserPassword()),
                Arrays.asList(new RoleEntity("ROLE_USER")));
        userRepo.save(userEntity);

    }

    @Override
    public Boolean userExists(String email) {
        return userRepo.findUserEntityByUserEmail(email).isPresent();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
