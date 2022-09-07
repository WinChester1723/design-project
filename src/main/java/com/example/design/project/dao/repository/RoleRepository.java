package com.example.design.project.dao.repository;

import com.example.design.project.dao.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<RoleEntity, Integer> {
//    RoleEntity findByRole_name(String name);
}
