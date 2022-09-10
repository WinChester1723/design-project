package com.example.design.project.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Integer userId;
    @NotEmpty(message = "First name can not be empty")
    private String firstName;
    @NotEmpty(message = "Last name can not be empty")
    private String lastName;
    @NotEmpty(message = "User name can not be empty")
    private String userName;
    @NotEmpty(message = "Email can not be empty")

    @Email(message = "Please provide a valid email id")
    private String userEmail;
    @NotEmpty(message = "Password can not be empty")
    private String userPassword;

    public String getsUserPassword() {
        return userPassword;
    }

    public void setsUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
