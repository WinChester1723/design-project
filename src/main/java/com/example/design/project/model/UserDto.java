package com.example.design.project.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
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
    @NotBlank(message = "Please return password")
    @Length(min = 8, message = "")
    private String rPassword;

    public String getsUserPassword() {
        return userPassword;
    }

    public void setsUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public UserDto(String firstName, String lastName, String userEmail) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userEmail = userEmail;
    }

    public String getrPassword() {
        return rPassword;
    }

    public void setrPassword(String rPassword) {
        this.rPassword = rPassword;
    }
}
