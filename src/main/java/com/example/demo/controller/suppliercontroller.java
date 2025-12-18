package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Supplier;
import com.example.demo.service.SupplierService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/suppliers")
public class SupplierController {

    @Autowired
    SupplierService supplierService;

    @PostMapping("/")
    public Supplier create(@RequestBody Supplier supplier) {
        return supplierService.createSupplier(supplier);
    }

    @PutMapping("/{id}")
    public Supplier update(@PathVariable Long id, @RequestBody Supplier supplier) {
        return supplierService.updateSupplier(id, supplier);
    }

    @GetMapping("/{id}")
    public Supplier get(@PathVariable Long id) {
        return supplierService.getSupplierById(id);
    }

    @GetMapping("/")
    public List<Supplier> getAll() {
        return supplierService.getAllSuppliers();
    }

    @PutMapping("/{id}/deactivate")
    public String deactivate(@PathVariable Long id) {
        supplierService.deactivateSupplier(id);
        return "Supplier deactivated";
    }
}
