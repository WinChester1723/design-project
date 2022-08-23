package com.example.design.project.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegisterDto {
    private Integer user_id;
    private String first_name;
    private String last_name;
    private String user_name;
    private String user_email;
    private String user_password;
}
