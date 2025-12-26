package com.example.demo.service.impl;

import com.example.demo.entity.SpendCategory;
import com.example.demo.repository.SpendCategoryRepository;
import com.example.demo.service.SpendCategoryService;

import java.util.List;

public class SpendCategoryServiceImpl
        implements SpendCategoryService {

    private final SpendCategoryRepository repository;

    // ✅ REQUIRED constructor
    public SpendCategoryServiceImpl(SpendCategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public SpendCategory save(SpendCategory sc) {
        return repository.save(sc);
    }

    @Override
    public List<SpendCategory> getAll() {
        return repository.findAll();
    }
}
