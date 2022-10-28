package com.example.design.project.service.serviceImplements;

import com.example.design.project.dao.entity.RoleEntity;
import com.example.design.project.dao.entity.UserEntity;
import com.example.design.project.dao.repository.RoleRepository;
import com.example.design.project.dao.repository.UserRepository;
import com.example.design.project.exception.UserException;
import com.example.design.project.mapper.UserMapper;
import com.example.design.project.model.RoleDto;
import com.example.design.project.model.UpdateUserDto;
import com.example.design.project.model.UserDto;
import com.example.design.project.model.enums.ErrorMessageEnum;
import com.example.design.project.model.enums.RoleEnum;
import com.example.design.project.service.CustomUserDetails;
import com.example.design.project.service.serviceInterface.UserService;
import com.example.design.project.validator.ValidUtilInt;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final ValidUtilInt validUtilInt;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        var userEntity = userRepository.findByUserEmail(email);
        if (userEntity == null) {
            throw new UsernameNotFoundException("No user found with the given email.");
        }
        return new CustomUserDetails(userEntity);
    }

    @Override
    public UserDto findById(int id) {
        var userEntity = userRepository.findById(id)
                .orElseThrow(() -> new UserException(ErrorMessageEnum.INVALID_USER.getMessage(id)));
        return UserMapper.INSTANCE.entityToDto(userEntity);
    }

    @Override
    public UserDto findByUserEmail(String email) {
        var userEntity = userRepository.findByUserEmail(email);
        return UserMapper.INSTANCE.entityToDto(userEntity);
    }

    //maybe used, but now is not current
//    @Override
//    public UserDto findUserByEmail(String userEmail) {
//        var userEntity = userRepository.findByUserEmail(userEmail);
//        return UserMapper.INSTANCE.entityToDto(userEntity);
//    }

    @Override
    public UserDto findByUserName(String userName) {
        var userEntity = userRepository.findByUserName(userName);
        return UserMapper.INSTANCE.entityToDto(userEntity);
    }

    @Override
    public List<UserDto> findAllAdmins() {
        return userRepository.findByRoles(RoleEnum.ADMIN)
                .stream()
                .map(userEntity -> UserMapper.INSTANCE.entityToDto(userEntity))
                .collect(Collectors.toList());
    }

    @Override
    public List<UserDto> findAllUsers() {
        return userRepository.findByRoles(RoleEnum.USER)
                .stream()
                .map(userEntity -> UserMapper.INSTANCE.entityToDto(userEntity))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getAllRole() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        List<String> roles = new ArrayList<>();
        for (GrantedAuthority g : authorities) {
            roles.add(g.getAuthority());
        }
        return roles;
    }

    @Override
    @Transactional
    public UserDto addUser(UserDto userDto) {

        var userEntity = UserEntity.builder()
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .userName(userDto.getUserName())
                .userEmail(userDto.getUserEmail())
                .userPassword(userDto.getUserPassword())
                .roles(roleRepository.findByRoleName(RoleEnum.USER.name()))
                .build();
        userRepository.save(userEntity);

        return UserMapper.INSTANCE.entityToDto(userEntity);
    }

    @Override
    @Transactional
    public UserDto addAdmin(UserDto userDto) {

        var userEntity = UserEntity.builder()
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .userName(userDto.getUserName())
                .userEmail(userDto.getUserEmail())
                .userPassword(userDto.getUserPassword())
                .roles(roleRepository.findByRoleName(RoleEnum.ADMIN.name()))
                .build();
        userRepository.save(userEntity);

        return UserMapper.INSTANCE.entityToDto(userEntity);
    }

    @Override
    @Transactional
    public UserDto updateUser(UpdateUserDto updateUserDto) {
        var userDto = findById(updateUserDto.getUserId());
        validUtilInt.validatePassword(userDto.getUserPassword());
        userDto.setFirstName(updateUserDto.getFirstName());
        userDto.setLastName(updateUserDto.getLastName());
        userDto.setUserEmail(updateUserDto.getUserEmail());
        userDto.setUserPassword(updateUserDto.getUserPassword());

        var userEntity = UserMapper.INSTANCE.dtoToEntity(userDto);
        userRepository.save(userEntity);

        return UserMapper.INSTANCE.entityToDto(userEntity);
    }

    @Override
    public void deleteById(int id) {
        userRepository.deleteById(id);
    }
}
