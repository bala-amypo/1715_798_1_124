package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.SpendCategory;

@Repository
public interface SpendCategoryRepository
        extends JpaRepository<SpendCategory, Long> {
}
