package com.example.design.project.model;

import com.example.design.project.dao.entity.RoleEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

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
    private Set<RoleEntity> roles;

    public UserDto(String firstName, String lastName, String userEmail) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userEmail = userEmail;
    }

//    public String getsUserPassword() {
//        return userPassword;
//    }

//    @NotBlank(message = "Please return password")
//    @Length(min = 8, message = "")
//    private String rPassword;

//    public void setsUserPassword(String userPassword) {
//        this.userPassword = userPassword;
//    }

//    public String getrPassword() {
//        return rPassword;
//    }
//
//    public void setrPassword(String rPassword) {
//        this.rPassword = rPassword;
//    }
}
