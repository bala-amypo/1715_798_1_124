package com.example.demo.service.impl;

import com.example.demo.entity.PurchaseOrder;
import com.example.demo.repository.PurchaseOrderRepository;
import com.example.demo.service.PurchaseOrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

    private final PurchaseOrderRepository p4o;

    public PurchaseOrderServiceImpl(PurchaseOrderRepository p4o) {
        this.p4o = p4o;
    }

    @Override
    public PurchaseOrder createPurchaseOrder(PurchaseOrder po) {
        return p4o.save(po);
    }

    @Override
    public PurchaseOrder updatePurchaseOrder(Long id, PurchaseOrder po) {
        PurchaseOrder existing = p4o.findById(id)
                .orElseThrow(() -> new RuntimeException("PurchaseOrder not found"));

        existing.setAmount(po.getAmount());
        existing.setOrderDate(po.getOrderDate());
        existing.setSupplierId(po.getSupplierId());

        return p4o.save(existing);
    }

    @Override
    public PurchaseOrder getPurchaseOrderById(Long id) {
        return p4o.findById(id)
                .orElseThrow(() -> new RuntimeException("PurchaseOrder not found"));
    }

    @Override
    public List<PurchaseOrder> getAllPurchaseOrders() {
        return p4o.findAll();
    }

    @Override
    public List<PurchaseOrder> getPurchaseOrdersBySupplier(Long supplierId) {
        return p4o.findBySupplierId(supplierId);
    }
}
