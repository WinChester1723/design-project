package com.example.design.project.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_role", schema = "art_design")
public class AdminEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "admin_id")
    private Integer admin_id;
    @Column(name = "admin_first_name")
    private String admin_first_name;
    @Column(name = "admin_last_name")
    private String admin_last_name;
    @Column(name = "admin_user_name")
    private String admin_user_name;
    @Column(name = "admin_email")
    private String admin_email;
    @Column(name = "admin_password")
    private String admin_password;

}
