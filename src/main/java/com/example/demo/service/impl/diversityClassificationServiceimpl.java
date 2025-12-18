package com.example.demo.service.impl;

import com.example.demo.entity.DiversityClassification;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.DiversityClassificationRepository;
import com.example.demo.service.DiversityClassificationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiversityClassificationServiceImpl implements DiversityClassificationService {

    private final DiversityClassificationRepository repo;

    public DiversityClassificationServiceImpl(DiversityClassificationRepository repo) {
        this.repo = repo;
    }

    @Override
    public DiversityClassification createClassification(DiversityClassification c) {
        return repo.save(c);
    }

    @Override
    public DiversityClassification updateClassification(Long id, DiversityClassification c) {
        DiversityClassification existing = getById(id);
        c.setId(existing.getId());
        return repo.save(c);
    }

    @Override
    public List<DiversityClassification> getAllClassifications() {
        return repo.findAll();
    }

    @Override
    public DiversityClassification getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Classification not found"));
    }

    @Override
    public void deactivateClassification(Long id) {
        DiversityClassification c = getById(id);
        c.setActive(false);
        repo.save(c);
    }
}
