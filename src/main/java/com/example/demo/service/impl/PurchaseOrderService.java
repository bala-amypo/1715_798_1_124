package com.example.demo.service.impl;

import com.example.demo.entity.PurchaseOrder;
import com.example.demo.entity.Supplier;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.PurchaseOrderRepository;
import com.example.demo.repository.SupplierRepository;
import com.example.demo.service.PurchaseOrderService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

    private final PurchaseOrderRepository poRepo;
    private final SupplierRepository supplierRepo;

    public PurchaseOrderServiceImpl(
            PurchaseOrderRepository poRepo,
            SupplierRepository supplierRepo) {
        this.poRepo = poRepo;
        this.supplierRepo = supplierRepo;
    }

    @Override
    public PurchaseOrder createPurchaseOrder(PurchaseOrder po) {
        if (po.getAmount() == null || po.getAmount().compareTo(BigDecimal.ZERO) <= 0) {
            throw new BadRequestException("Amount must be greater than zero");
        }
        return poRepo.save(po);
    }

    @Override
    public PurchaseOrder updatePurchaseOrder(Long id, PurchaseOrder po) {
        PurchaseOrder existing = getPurchaseOrderById(id);
        po.setId(existing.getId());
        return poRepo.save(po);
    }

    @Override
    public PurchaseOrder getPurchaseOrderById(Long id) {
        return poRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("PO not found"));
    }

    @Override
    public List<PurchaseOrder> getAllPurchaseOrders() {
        return poRepo.findAll();
    }

    @Override
    public List<PurchaseOrder> getPurchaseOrdersBySupplier(Long supplierId) {
        Supplier supplier = supplierRepo.findById(supplierId)
                .orElseThrow(() -> new ResourceNotFoundException("Supplier not found"));
        return poRepo.findBySupplier(supplier);
    }
}
