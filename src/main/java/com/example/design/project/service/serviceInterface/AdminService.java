package com.example.design.project.service.serviceInterface;

import com.example.design.project.model.AdminDto;

import java.util.List;

public interface AdminService {

    void save(AdminDto adminDto);

    Boolean adminExists(String email);

    AdminDto findByAdminEmail(String email);

    AdminDto findByUsername(String name);

    List<AdminDto> allAdmins();

    List<String> getAllRole();

//    AdminDto findByEmail();
}
