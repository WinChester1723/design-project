package com.example.design.project.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminDto {

    private Integer admin_id;
    private String admin_first_name;
    private String admin_last_name;
    private String admin_user_name;
    private String admin_email;
    private String admin_password;
}
