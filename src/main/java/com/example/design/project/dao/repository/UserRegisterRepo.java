package com.example.design.project.dao.repository;

import com.example.design.project.dao.entity.UserRegisterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRegisterRepo extends JpaRepository<UserRegisterEntity, Integer> {
//    UserRegisterEntity findByUser_name(String name);

    @Query(value = "SELECT user_name FROM art_design.user_register",
    nativeQuery = true)
    List<UserRegisterEntity> showUserName();
}
