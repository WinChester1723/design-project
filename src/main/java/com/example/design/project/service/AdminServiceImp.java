package com.example.design.project.service;

import com.example.design.project.dao.entity.AdminEntity;
import com.example.design.project.dao.entity.RoleEntity;
import com.example.design.project.dao.repository.AdminRepository;
import com.example.design.project.mapper.AdminMapper;
import com.example.design.project.model.AdminDto;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminServiceImp implements AdminService {

    private AdminRepository adminRepository;

    public AdminServiceImp(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    @Transactional
    public void save(AdminDto adminDto) {
        AdminEntity adminEntity = new AdminEntity(adminDto.getAdminFirstName(),
                adminDto.getAdminLastName(),
                adminDto.getAdminUserName(),
                adminDto.getAdminEmail(),
                new BCryptPasswordEncoder().encode(adminDto.getAdminPassword()),
                Arrays.asList(new RoleEntity("ROLE_ADMIN")));
        adminRepository.save(adminEntity);

    }

    @Override
    public Boolean adminExists(String email) {
        return adminRepository.findAdminEntityByAdminEmail(email).isPresent();
    }


    @Override
    public List<AdminDto> allAdmins() {
        return adminRepository.findByRoles("ROLE_ADMIN")
                .stream()
                .map(adminEntity -> AdminMapper.INSTANCE.entityToDto(adminEntity))
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
