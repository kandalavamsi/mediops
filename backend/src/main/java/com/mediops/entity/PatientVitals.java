package com.mediops.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Entity
@Table(name = "patient_vitals")
public class PatientVitals {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @Column(name = "recorded_at", nullable = false)
    private OffsetDateTime recordedAt;

    @Column(name = "temperature_celsius", precision = 4, scale = 1)
    private BigDecimal temperatureCelsius;

    @Column(name = "heart_rate_bpm")
    private Integer heartRateBpm;

    @Column(name = "systolic_bp_mmhg")
    private Integer systolicBpMmhg;

    @Column(name = "diastolic_bp_mmhg")
    private Integer diastolicBpMmhg;

    @Column(name = "respiratory_rate_bpm")
    private Integer respiratoryRateBpm;

    @Column(name = "oxygen_saturation_percent", precision = 5, scale = 2)
    private BigDecimal oxygenSaturationPercent;

    @Column(name = "blood_glucose_mg_dl", precision = 6, scale = 2)
    private BigDecimal bloodGlucoseMgDl;

    @Column(name = "height_cm", precision = 5, scale = 2)
    private BigDecimal heightCm;

    @Column(name = "weight_kg", precision = 6, scale = 2)
    private BigDecimal weightKg;

    @Column(name = "notes")
    private String notes;

    @Column(name = "created_at", nullable = false)
    private OffsetDateTime createdAt;

    public PatientVitals() {
    }

    public Long getId() {
        return id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public OffsetDateTime getRecordedAt() {
        return recordedAt;
    }

    public void setRecordedAt(OffsetDateTime recordedAt) {
        this.recordedAt = recordedAt;
    }

    public BigDecimal getTemperatureCelsius() {
        return temperatureCelsius;
    }

    public void setTemperatureCelsius(BigDecimal temperatureCelsius) {
        this.temperatureCelsius = temperatureCelsius;
    }

    public Integer getHeartRateBpm() {
        return heartRateBpm;
    }

    public void setHeartRateBpm(Integer heartRateBpm) {
        this.heartRateBpm = heartRateBpm;
    }

    public Integer getSystolicBpMmhg() {
        return systolicBpMmhg;
    }

    public void setSystolicBpMmhg(Integer systolicBpMmhg) {
        this.systolicBpMmhg = systolicBpMmhg;
    }

    public Integer getDiastolicBpMmhg() {
        return diastolicBpMmhg;
    }

    public void setDiastolicBpMmhg(Integer diastolicBpMmhg) {
        this.diastolicBpMmhg = diastolicBpMmhg;
    }

    public Integer getRespiratoryRateBpm() {
        return respiratoryRateBpm;
    }

    public void setRespiratoryRateBpm(Integer respiratoryRateBpm) {
        this.respiratoryRateBpm = respiratoryRateBpm;
    }

    public BigDecimal getOxygenSaturationPercent() {
        return oxygenSaturationPercent;
    }

    public void setOxygenSaturationPercent(BigDecimal oxygenSaturationPercent) {
        this.oxygenSaturationPercent = oxygenSaturationPercent;
    }

    public BigDecimal getBloodGlucoseMgDl() {
        return bloodGlucoseMgDl;
    }

    public void setBloodGlucoseMgDl(BigDecimal bloodGlucoseMgDl) {
        this.bloodGlucoseMgDl = bloodGlucoseMgDl;
    }

    public BigDecimal getHeightCm() {
        return heightCm;
    }

    public void setHeightCm(BigDecimal heightCm) {
        this.heightCm = heightCm;
    }

    public BigDecimal getWeightKg() {
        return weightKg;
    }

    public void setWeightKg(BigDecimal weightKg) {
        this.weightKg = weightKg;
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
}