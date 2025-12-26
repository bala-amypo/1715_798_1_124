package com.example.demo.repository;

import com.example.demo.entity.DiversityTarget;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DiversityTargetRepository
        extends JpaRepository<DiversityTarget, Long> {

    Optional<DiversityTarget> findByTargetYear(int targetYear);
}
