package com.example.demo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.PurchaseOrder;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.PurchaseOrderRepository;
import com.example.demo.service.PurchaseOrderService;

@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

    @Autowired
    PurchaseOrderRepository repo;

    @Override
    public PurchaseOrder createPurchaseOrder(PurchaseOrder po) {
        if (po.getAmount() == null || po.getAmount().doubleValue() <= 0) {
            throw new BadRequestException("Amount must be greater than 0");
        }
        return repo.save(po);
    }

    @Override
    public PurchaseOrder updatePurchaseOrder(Long id, PurchaseOrder po) {
        po.setId(id);
        return repo.save(po);
    }

    @Override
    public PurchaseOrder getPurchaseOrderById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("PO not found"));
    }

    @Override
    public List<PurchaseOrder> getAllPurchaseOrders() {
        return repo.findAll();
    }

    @Override
    public List<PurchaseOrder> getPurchaseOrdersBySupplier(Long supplierId) {
        return repo.findAll()
                .stream()
                .filter(po -> po.getSupplier() != null
                        && supplierId.equals(po.getSupplier().getId()))
                .collect(Collectors.toList());
    }
}
