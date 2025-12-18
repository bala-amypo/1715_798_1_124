package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(
    name = "spend_categories",
    uniqueConstraints = @UniqueConstraint(columnNames = "name")
)
public class SpendCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    private String description;

    private Boolean active = true;

}
