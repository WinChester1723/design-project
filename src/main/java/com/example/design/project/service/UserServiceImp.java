package com.example.design.project.service;

import com.example.design.project.dao.entity.RoleEntity;
import com.example.design.project.dao.entity.UserEntity;
import com.example.design.project.dao.repository.UserRepository;
import com.example.design.project.mapper.UserMapper;
import com.example.design.project.model.UserDto;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImp implements UserService, UserDetailsService {
    private UserRepository userRepository;

    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public void save(UserDto userDto) {
        UserEntity userEntity = new UserEntity(userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getUserName(),
                userDto.getUserEmail(),
                new BCryptPasswordEncoder().encode(userDto.getUserPassword()),
                Arrays.asList(new RoleEntity("ROLE_USER")));
        userRepository.save(userEntity);

    }

    @Override
    public Boolean userExists(String email) {
        return userRepository.findUserEntityByUserEmail(email).isPresent();
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByUserEmail(email);

        if (userEntity == null) {
            throw new UsernameNotFoundException("User name and password is not correct");
        }
        return new UserDetailService(userEntity);
    }

    @Override
    public UserDto findByEmail() {
        Object obj = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String userEmail;
        if (obj instanceof UserDetails) {
            userEmail = ((UserDetails) obj).getUsername();
        } else {
            userEmail = obj.toString();
        }
        if (userEmail == "anonymousUser") {
            return new UserDto("User", "User", "anonymousUser");
        } else {
            return UserMapper.INSTANCE.entityToDto(userRepository.findByUserEmail(userEmail));
        }
    }

    @Override
    public List<UserDto> allUsers() {
        return userRepository.findByRoles("ROLE_USER")
                .stream()
                .map(userEntity -> UserMapper.INSTANCE.entityToDto(userEntity))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getAllRole() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        List<String> roles = new ArrayList<>();
        for (GrantedAuthority g : authorities){
            roles.add(g.getAuthority());
        }
        return roles;
    }
}
