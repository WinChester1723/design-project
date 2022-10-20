package com.example.design.project.service.serviceImplements;

import com.example.design.project.dao.entity.AdminEntity;
import com.example.design.project.dao.repository.AdminRepository;
import com.example.design.project.dao.repository.RoleRepository;
import com.example.design.project.mapper.AdminMapper;
import com.example.design.project.model.AdminDto;
import com.example.design.project.service.serviceInterface.AdminService;
import com.example.design.project.service.CustomAdminDetails;
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
public class AdminServiceImp implements AdminService, UserDetailsService {

    private AdminRepository adminRepository;
    private RoleRepository roleRepository;


    public AdminServiceImp(AdminRepository adminRepository, RoleRepository roleRepository) {
        this.adminRepository = adminRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    @Transactional
    public void save(AdminDto adminDto) {
        var adminEntity = new AdminEntity();

        adminEntity.setAdminFirstName(adminDto.getAdminFirstName());
        adminEntity.setAdminLastName(adminDto.getAdminLastName());
        adminEntity.setAdminUserName(adminDto.getAdminUserName());
        adminEntity.setAdminEmail(adminDto.getAdminEmail());
        adminEntity.setAdminPassword(new BCryptPasswordEncoder().encode(adminDto.getAdminPassword()));
        adminEntity.setRoles(Arrays.asList(roleRepository.findByRoleName("ROLE_ADMIN")));

        adminRepository.save(adminEntity);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        AdminEntity adminEntity = adminRepository.findByAdminEmail(email);
        if (adminEntity == null){
            throw new UsernameNotFoundException("No admin found with the given email.");
        }
        return new CustomAdminDetails(adminEntity);
    }
    @Override
    public AdminDto findByAdminEmail(String email) {
        var adminEntity = adminRepository.findByAdminEmail(email);
        return AdminMapper.INSTANCE.entityToDto(adminEntity);
    }

    @Override
    public Boolean adminExists(String email) {
        return adminRepository.findAdminEntityByAdminEmail(email).isPresent();
    }

    @Override
    public AdminDto findByUsername(String name) {
        var adminEntity = adminRepository.findByAdminUserName(name);
        return AdminMapper.INSTANCE.entityToDto(adminEntity);
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
