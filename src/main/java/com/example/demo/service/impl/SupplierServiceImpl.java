package com.example.demo.service.impl;

import com.example.demo.repository.SupplierRepository;
import com.example.demo.service.SupplierService;

public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository repository;

    // ✅ REQUIRED by test
    public SupplierServiceImpl(SupplierRepository repository) {
        this.repository = repository;
    }
}
