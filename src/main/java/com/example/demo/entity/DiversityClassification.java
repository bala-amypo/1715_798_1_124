package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(
    name = "diversity_classifications",
    uniqueConstraints = @UniqueConstraint(columnNames = "code")
)
public class DiversityClassification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String code;

    private String description;

    private Boolean active = true;

}
