package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.SpendCategory;
import com.example.demo.service.SpendCategoryService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/categories")
public class SpendCategoryController {

    @Autowired
    SpendCategoryService service;

    @PostMapping("/")
    public SpendCategory create(@RequestBody SpendCategory category) {
        return service.createCategory(category);
    }

    @PutMapping("/{id}")
    public SpendCategory update(@PathVariable Long id,
                                @RequestBody SpendCategory category) {
        return service.updateCategory(id, category);
    }

    @GetMapping("/{id}")
    public SpendCategory get(@PathVariable Long id) {
        return service.getCategoryById(id);
    }

    @GetMapping("/")
    public List<SpendCategory> getAll() {
        return service.getAllCategories();
    }

    @PutMapping("/{id}/deactivate")
    public String deactivate(@PathVariable Long id) {
        service.deactivateCategory(id);
        return "Category deactivated";
    }
}
