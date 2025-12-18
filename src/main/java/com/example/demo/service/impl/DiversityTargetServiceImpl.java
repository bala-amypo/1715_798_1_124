package com.example.demo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.DiversityTarget;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.DiversityTargetRepository;
import com.example.demo.service.DiversityTargetService;

@Service
public class DiversityTargetServiceImpl implements DiversityTargetService {

    @Autowired
    DiversityTargetRepository repo;

    @Override
    public DiversityTarget createTarget(DiversityTarget target) {
        return repo.save(target);
    }

    @Override
    public DiversityTarget updateTarget(Long id, DiversityTarget target) {
        target.setId(id);
        return repo.save(target);
    }

    @Override
    public List<DiversityTarget> getTargetsByYear(Integer year) {
        return repo.findAll()
                .stream()
                .filter(t -> year.equals(t.getTargetYear()))
                .collect(Collectors.toList());
    }

    @Override
    public List<DiversityTarget> getAllTargets() {
        return repo.findAll();
    }

    @Override
    public void deactivateTarget(Long id) {
        DiversityTarget t = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Target not found"));
        t.setActive(false);
        repo.save(t);
    }
}
