package com.mediops.entity;
import jakarta.persistence.*;
import java.time.OffsetDateTime;

@Entity
@Table(name="wards")
public class Ward {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="ward_code", nullable=false,unique=true,length=20)
    private String wardCode;

    @Column(name="name",nullable = false,length=100)
    private String name;

    @Column(name="ward_type",nullable = false,length=30)
    private String wardType;

    @ManyToOne(fetch=FetchType.LAZY, optional=false)
    @JoinColumn(name="department_id", nullable = false)
    private Department department;

    @Column(name="floor",length=30)
    private String floor;

    @Column(name="capacity",nullable = false)
    private Integer capacity;

    @Column(name="status",nullable = false,length=20)
    private String status;

    @Column(name = "created_at", nullable = false)
    private OffsetDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private OffsetDateTime updatedAt;

    public Ward() {
    }
    public Long getId() {
        return id;
    }

    public String getWardCode() {
        return wardCode;
    }

    public void setWardCode(String wardCode) {
        this.wardCode = wardCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWardType() {
        return wardType;
    }

    public void setWardType(String wardType) {
        this.wardType = wardType;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public OffsetDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(OffsetDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
