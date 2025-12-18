package com.example.demo.entity;

import jakarta.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(
    name = "suppliers",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = "name"),
        @UniqueConstraint(columnNames = "email"),
        @UniqueConstraint(columnNames = "registration_number")
    }
)
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(name = "registration_number", unique = true)
    private String registrationNumber;

    @Column(nullable = false, unique = true)
    private String email;

    private String phone;
    private String address;

    @ManyToMany
    @JoinTable(
        name = "supplier_diversity",
        joinColumns = @JoinColumn(name = "supplier_id"),
        inverseJoinColumns = @JoinColumn(name = "classification_id")
    )
    private List<DiversityClassification> diversityClassifications;

    @Column(nullable = false)
    private Boolean isActive = true;

    private Timestamp createdAt;
    private Timestamp updatedAt;

  
    public Supplier() {}

    public Supplier(Long id, String name, String registrationNumber, String email, String phone,
                    String address, List<DiversityClassification> diversityClassifications,
                    Boolean isActive, Timestamp createdAt, Timestamp updatedAt) {
        this.id = id;
        this.name = name;
        this.registrationNumber = registrationNumber;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.diversityClassifications = diversityClassifications;
        this.isActive = isActive;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    @PrePersist
    public void prePersist() {
        this.createdAt = new Timestamp(System.currentTimeMillis());
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = new Timestamp(System.currentTimeMillis());
    }

  
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getRegistrationNumber() { return registrationNumber; }
    public void setRegistrationNumber(String registrationNumber) { this.registrationNumber = registrationNumber; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public List<DiversityClassification> getDiversityClassifications() {
        return diversityClassifications;
    }
    public void setDiversityClassifications(List<DiversityClassification> diversityClassifications) {
        this.diversityClassifications = diversityClassifications;
    }

    public Boolean getIsActive() { return isActive; }
    public void setIsActive(Boolean isActive) { this.isActive = isActive; }

    public Timestamp getCreatedAt() { return createdAt; }
    public Timestamp getUpdatedAt() { return updatedAt; }
}
