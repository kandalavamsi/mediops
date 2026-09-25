package com.mediops.entity;

import jakarta.persistence.*;
import java.time.OffsetDateTime;

@Entity
@Table(name = "admissions")
public class Admission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "admission_code", nullable = false, unique = true, length = 20)
    private String admissionCode;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bed_id")
    private Bed bed;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "emergency_id")
    private Emergency emergency;

    @Column(name = "admission_type", nullable = false, length = 30)
    private String admissionType;

    @Column(name = "admitted_at", nullable = false)
    private OffsetDateTime admittedAt;

    @Column(name = "expected_discharge_at")
    private OffsetDateTime expectedDischargeAt;

    @Column(name = "discharged_at")
    private OffsetDateTime dischargedAt;

    @Column(name = "discharge_summary")
    private String dischargeSummary;

    @Column(name = "status", nullable = false, length = 20)
    private String status;

    @Column(name = "notes")
    private String notes;

    @Column(name = "created_at", nullable = false)
    private OffsetDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private OffsetDateTime updatedAt;

    public Admission() {
    }

    public Long getId() {
        return id;
    }

    public String getAdmissionCode() {
        return admissionCode;
    }

    public void setAdmissionCode(String admissionCode) {
        this.admissionCode = admissionCode;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Bed getBed() {
        return bed;
    }

    public void setBed(Bed bed) {
        this.bed = bed;
    }

    public Emergency getEmergency() {
        return emergency;
    }

    public void setEmergency(Emergency emergency) {
        this.emergency = emergency;
    }

    public String getAdmissionType() {
        return admissionType;
    }

    public void setAdmissionType(String admissionType) {
        this.admissionType = admissionType;
    }

    public OffsetDateTime getAdmittedAt() {
        return admittedAt;
    }

    public void setAdmittedAt(OffsetDateTime admittedAt) {
        this.admittedAt = admittedAt;
    }

    public OffsetDateTime getExpectedDischargeAt() {
        return expectedDischargeAt;
    }

    public void setExpectedDischargeAt(OffsetDateTime expectedDischargeAt) {
        this.expectedDischargeAt = expectedDischargeAt;
    }

    public OffsetDateTime getDischargedAt() {
        return dischargedAt;
    }

    public void setDischargedAt(OffsetDateTime dischargedAt) {
        this.dischargedAt = dischargedAt;
    }

    public String getDischargeSummary() {
        return dischargeSummary;
    }

    public void setDischargeSummary(String dischargeSummary) {
        this.dischargeSummary = dischargeSummary;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
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