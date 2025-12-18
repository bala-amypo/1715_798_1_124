package com.example.demo.service.impl;

import com.example.demo.entity.DiversityTarget;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.DiversityTargetRepository;
import com.example.demo.service.DiversityTargetService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiversityTargetServiceImpl implements DiversityTargetService {

    private final DiversityTargetRepository repo;

    public DiversityTargetServiceImpl(DiversityTargetRepository repo) {
        this.repo = repo;
    }

    @Override
    public DiversityTarget createTarget(DiversityTarget target) {
        return repo.save(target);
    }

    @Override
    public DiversityTarget updateTarget(Long id, DiversityTarget target) {
        DiversityTarget existing = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Target not found"));
        target.setId(existing.getId());
        return repo.save(target);
    }

    @Override
    public List<DiversityTarget> getTargetsByYear(Integer year) {
        return repo.findAll()
                .stream()
                .filter(t -> year.equals(t.getTargetYear()))
                .toList();
    }

    @Override
    public List<DiversityTarget> getAllTargets() {
        return repo.findAll();
    }

    @Override
    public void deactivateTarget(Long id) {
        DiversityTarget target = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Target not found"));
        target.setActive(false);
        repo.save(target);
    }
}
