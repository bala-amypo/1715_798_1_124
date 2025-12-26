package com.example.demo.service.impl;

import com.example.demo.entity.PurchaseOrder;
import com.example.demo.repository.PurchaseOrderRepository;
import com.example.demo.service.PurchaseOrderService;

import java.util.List;

public class PurchaseOrderServiceImpl
        implements PurchaseOrderService {

    private final PurchaseOrderRepository repository;

    // ✅ REQUIRED constructor
    public PurchaseOrderServiceImpl(
            PurchaseOrderRepository repository) {
        this.repository = repository;
    }

    @Override
    public PurchaseOrder createPurchaseOrder(PurchaseOrder po) {
        return repository.save(po);
    }

    @Override
    public PurchaseOrder updatePurchaseOrder(Long id, PurchaseOrder po) {
        PurchaseOrder existing =
                repository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException("PurchaseOrder not found"));

        existing.setPoNumber(po.getPoNumber());
        existing.setDateIssued(po.getDateIssued());
        existing.setSupplier(po.getSupplier());
        existing.setCategory(po.getCategory());
        existing.setAmount(po.getAmount());

        return repository.save(existing);
    }

    @Override
    public PurchaseOrder getPurchaseOrderById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("PurchaseOrder not found"));
    }

    @Override
    public List<PurchaseOrder> getAllPurchaseOrders() {
        return repository.findAll();
    }

    @Override
    public List<PurchaseOrder> getPurchaseOrdersBySupplier(Long supplierId) {
        return repository.findBySupplier_Id(supplierId);
    }
}
