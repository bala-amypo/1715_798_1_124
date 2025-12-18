package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Supplier;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.SupplierRepository;
import com.example.demo.service.SupplierService;

@Service   // ✅ REQUIRED
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierRepository repo;

    @Override
    public Supplier createSupplier(Supplier supplier) {
        return repo.save(supplier);
    }

    @Override
    public Supplier updateSupplier(Long id, Supplier supplier) {
        supplier.setId(id);
        return repo.save(supplier);
    }

    @Override
    public Supplier getSupplierById(Long id) {
        return repo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Supplier not found with id " + id));
    }

    @Override
    public List<Supplier> getAllSuppliers() {
        return repo.findAll();
    }

    @Override
    public void deactivateSupplier(Long id) {
        Supplier supplier = repo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Supplier not found with id " + id));
        supplier.setIsActive(false);
        repo.save(supplier);
    }
}
