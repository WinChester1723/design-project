package com.example.design.project.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminDto {

    private Integer adminId;
    @NotEmpty(message = "First name can not be empty")
    private String adminFirstName;
    @NotEmpty(message = "Last name can not be empty")
    private String adminLastName;
    @NotEmpty(message = "User name can not be empty")
    private String adminUserName;
    @NotEmpty(message = "Email can not be empty")
    @Email(message = "Please provide a valid email id")
    private String adminEmail;
    @NotEmpty(message = "Password can not be empty")
    private String adminPassword;

    public String getsAdminPassword() {
        return adminPassword;
    }

    public void setsAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }
}
