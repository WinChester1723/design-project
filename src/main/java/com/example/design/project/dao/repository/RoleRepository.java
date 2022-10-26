package com.example.design.project.dao.repository;

import com.example.design.project.dao.entity.RoleEntity;
import com.example.design.project.model.enums.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Integer> {
    RoleEntity findByRoleName(RoleEnum roleEnum);
}
