package com.example.demo.service;

import com.example.demo.entity.PurchaseOrder;
import java.util.List;

public interface PurchaseOrderService {

    PurchaseOrder create(PurchaseOrder po);

    List<PurchaseOrder> getAll();

    // 🔴 THIS METHOD MUST BE IMPLEMENTED
    List<PurchaseOrder> getPurchaseOrdersBySupplier(Long supplierId);
}
