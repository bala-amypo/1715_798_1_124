package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.DiversityClassification;

@Repository
public interface DiversityClassificationRepository
        extends JpaRepository<DiversityClassification, Long> {
}
