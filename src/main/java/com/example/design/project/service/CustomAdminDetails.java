package com.example.design.project.service;

import com.example.design.project.dao.entity.AdminEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.stream.Collectors;

public class CustomAdminDetails implements UserDetails {
    private String email;
    private String password;
    private Collection<GrantedAuthority> roles;

    private AdminEntity adminEntity;

    public CustomAdminDetails(AdminEntity adminEntity) {
        this.adminEntity = adminEntity;
        this.email = adminEntity.getAdminEmail();
        this.password = adminEntity.getAdminPassword();
        this.roles = adminEntity.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getRoleName())).collect(Collectors.toList());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
