package com.example.design.project.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_register", schema = "art_design")
public class UserRegisterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "username")
    private String username;
    @Column(name = "user_surname")
    private String surname;
    @Column(name = "user_name")
    private String user_name;
    @Column(name = "user_email")
    private String user_email;
    @Column(name = "user_password")
    private String user_password;
}
