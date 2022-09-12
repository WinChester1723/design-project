package com.example.design.project.dao.repository;

import com.example.design.project.dao.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    UserEntity findByUserEmail(String email);

    Optional<UserEntity> findUserEntityByUserEmail(String email);
//    @Query(value = "SELECT user_name FROM art_design.user_register",
//    nativeQuery = true)
//    List<UserEntity> showUserName(String userName);

    UserEntity findByUserName(String name);

    @Query(value = "select * from users_roles ur  join user_register u on ur.user_id=u.user_id " +
            "join role r on ur.role_id = r.role_id and r.role_name=?1 ", nativeQuery = true)
    List<UserEntity> findByRoles(String role);

}
