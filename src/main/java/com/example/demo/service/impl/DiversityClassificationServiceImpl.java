package com.example.demo.service.impl;

import com.example.demo.entity.DiversityClassification;
import com.example.demo.repository.DiversityClassificationRepository;
import com.example.demo.service.DiversityClassificationService;

import java.util.List;

public class DiversityClassificationServiceImpl
        implements DiversityClassificationService {

    private final DiversityClassificationRepository repository;

    // ✅ REQUIRED constructor
    public DiversityClassificationServiceImpl(
            DiversityClassificationRepository repository) {
        this.repository = repository;
    }

    @Override
    public DiversityClassification save(DiversityClassification dc) {
        return repository.save(dc);
    }

    @Override
    public List<DiversityClassification> getAll() {
        return repository.findAll();
    }
}
