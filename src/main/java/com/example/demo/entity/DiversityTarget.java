package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "diversity_targets")
public class DiversityTarget {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer targetYear;

    @ManyToOne
    @JoinColumn(name = "classification_id", nullable = false)
    private DiversityClassification classification;

    private Double targetPercentage;

    private Boolean active = true;

}
