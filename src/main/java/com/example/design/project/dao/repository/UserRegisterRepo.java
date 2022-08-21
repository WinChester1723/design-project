package com.example.design.project.dao.repository;

import com.example.design.project.dao.entity.UserRegisterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRegisterRepo extends JpaRepository<UserRegisterEntity, Integer> {
}
