package com.example.design.project.dao.repository;

import com.example.design.project.dao.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<UserEntity, Integer> {

    UserEntity findByUserEmail(String email);

    Optional<UserEntity> findUserEntityByUserEmail(String email);
    @Query(value = "SELECT user_name FROM art_design.user_register",
    nativeQuery = true)
    List<UserEntity> showUserName();
}
