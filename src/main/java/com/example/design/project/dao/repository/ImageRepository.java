package com.example.design.project.dao.repository;

import com.example.design.project.dao.entity.ImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ImageRepository extends JpaRepository<ImageEntity, Integer> {
//    Optional<ImageEntity> findByImage_name(String name);
}
