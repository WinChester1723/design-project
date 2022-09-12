package com.example.design.project.dao.repository;

import com.example.design.project.dao.entity.AdminEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AdminRepository extends JpaRepository<AdminEntity, Integer> {
    AdminEntity findByAdminEmail(String email);

    Optional<AdminEntity> findAdminEntityByAdminEmail(String email);

    AdminEntity findByAdminUserName(String name);

    @Query(value = "select * from admins_roles ar  join admin_db a on ar.admin_id=a.admin_id " +
            "join role r on ar.role_id = r.role_id and r.role_name=?1 ", nativeQuery = true)
    List<AdminEntity> findByRoles(String role);
}
