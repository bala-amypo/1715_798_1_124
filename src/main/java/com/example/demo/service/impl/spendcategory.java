package com.example.demo.service.impl;

import com.example.demo.entity.SpendCategory;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.SpendCategoryRepository;
import com.example.demo.service.SpendCategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpendCategoryServiceImpl implements SpendCategoryService {

    private final SpendCategoryRepository repo;

    public SpendCategoryServiceImpl(SpendCategoryRepository repo) {
        this.repo = repo;
    }

    @Override
    public SpendCategory createCategory(SpendCategory category) {
        return repo.save(category);
    }

    @Override
    public SpendCategory updateCategory(Long id, SpendCategory category) {
        SpendCategory existing = getCategoryById(id);
        category.setId(existing.getId());
        return repo.save(category);
    }

    @Override
    public SpendCategory getCategoryById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found"));
    }

    @Override
    public List<SpendCategory> getAllCategories() {
        return repo.findAll();
    }

    @Override
    public void deactivateCategory(Long id) {
        SpendCategory c = getCategoryById(id);
        c.setActive(false);
        repo.save(c);
    }
}
