package com.example.demo.service.impl;

import com.example.demo.entity.DiversityTarget;
import com.example.demo.repository.DiversityTargetRepository;
import com.example.demo.service.DiversityTargetService;

import java.util.List;

public class DiversityTargetServiceImpl
        implements DiversityTargetService {

    private final DiversityTargetRepository repository;

    // ✅ REQUIRED constructor
    public DiversityTargetServiceImpl(
            DiversityTargetRepository repository) {
        this.repository = repository;
    }

    @Override
    public DiversityTarget save(DiversityTarget target) {
        return repository.save(target);
    }

    @Override
    public DiversityTarget getByYear(int year) {
        return repository.findByTargetYear(year)
                .orElse(null);
    }

    @Override
    public List<DiversityTarget> getAll() {
        return repository.findAll();
    }
}
