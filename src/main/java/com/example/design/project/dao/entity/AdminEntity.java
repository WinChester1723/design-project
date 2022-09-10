package com.example.design.project.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "admin_db", schema = "art_design", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class AdminEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "admin_id")
    private Integer adminId;
    @Column(name = "admin_first_name")
    private String adminFirstName;
    @Column(name = "admin_last_name")
    private String adminLastName;
    @Column(name = "admin_user_name",unique = true)
    private String adminUserName;
    @Column(name = "admin_email")
    private String adminEmail;
    @Column(name = "admin_password")
    private String adminPassword;
    @ManyToMany(fetch=FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(schema = "art_design",name="admins_roles",joinColumns=@JoinColumn( name="admin_id",referencedColumnName = "admin_id"),
            inverseJoinColumns = @JoinColumn(name="role_id",referencedColumnName = "role_id"))
    private Collection<RoleEntity> roles;

}
