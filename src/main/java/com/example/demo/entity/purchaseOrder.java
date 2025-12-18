package com.example.demo.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(
    name = "purchase_orders",
    uniqueConstraints = @UniqueConstraint(columnNames = "po_number")
)
public class PurchaseOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "po_number", unique = true, nullable = false)
    private String poNumber;

    @ManyToOne
    @JoinColumn(name = "supplier_id", nullable = false)
    private Supplier supplier;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private SpendCategory category;

    @Column(nullable = false)
    private BigDecimal amount;

    private LocalDate dateIssued;

    private String approvedBy;
    private String notes;

}
