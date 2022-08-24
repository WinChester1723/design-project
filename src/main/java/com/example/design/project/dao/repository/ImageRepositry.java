package com.example.design.project.dao.repository;

import com.example.design.project.dao.entity.ImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepositry extends JpaRepository<ImageEntity, Integer> {
}
