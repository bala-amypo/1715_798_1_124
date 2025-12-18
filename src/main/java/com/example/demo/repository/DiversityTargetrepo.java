package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.DiversityTarget;

@Repository
public interface DiversityTargetRepository
        extends JpaRepository<DiversityTarget, Long> {
}
