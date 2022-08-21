package com.example.design.project.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegisterDto {
    private Integer id;
    private String username;
    private String user_surname;
    private String user_name;
    private String user_email;
    private String user_password;
}
