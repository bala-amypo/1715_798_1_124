package com.example.demo.service.impl;

import com.example.demo.entity.PurchaseOrder;
import com.example.demo.repository.PurchaseOrderRepository;
import com.example.demo.service.PurchaseOrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

    // ✅ DECLARED
    private final PurchaseOrderRepository p4o;

    // ✅ CONSTRUCTOR INJECTION
    public PurchaseOrderServiceImpl(PurchaseOrderRepository p4o) {
        this.p4o = p4o;
    }

    @Override
    public PurchaseOrder create(PurchaseOrder po) {
        return p4o.save(po);
    }

    @Override
    public List<PurchaseOrder> getAll() {
        return p4o.findAll();
    }
}
