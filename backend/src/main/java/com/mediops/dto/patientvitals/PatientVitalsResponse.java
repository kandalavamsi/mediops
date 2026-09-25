
package com.mediops.dto.patientvitals;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class PatientVitalsResponse {

    private Long id;
    private Long patientId;
    private String patientCode;
    private String patientName;
    private OffsetDateTime recordedAt;
    private BigDecimal temperatureCelsius;
    private Integer heartRateBpm;
    private Integer systolicBpMmhg;
    private Integer diastolicBpMmhg;
    private Integer respiratoryRateBpm;
    private BigDecimal oxygenSaturationPercent;
    private BigDecimal bloodGlucoseMgDl;
    private BigDecimal heightCm;
    private BigDecimal weightKg;
    private String notes;
    private OffsetDateTime createdAt;

    public PatientVitalsResponse(
            Long id,
            Long patientId,
            String patientCode,
            String patientName,
            OffsetDateTime recordedAt,
            BigDecimal temperatureCelsius,
            Integer heartRateBpm,
            Integer systolicBpMmhg,
            Integer diastolicBpMmhg,
            Integer respiratoryRateBpm,
            BigDecimal oxygenSaturationPercent,
            BigDecimal bloodGlucoseMgDl,
            BigDecimal heightCm,
            BigDecimal weightKg,
            String notes,
            OffsetDateTime createdAt) {

        this.id = id;
        this.patientId = patientId;
        this.patientCode = patientCode;
        this.patientName = patientName;
        this.recordedAt = recordedAt;
        this.temperatureCelsius = temperatureCelsius;
        this.heartRateBpm = heartRateBpm;
        this.systolicBpMmhg = systolicBpMmhg;
        this.diastolicBpMmhg = diastolicBpMmhg;
        this.respiratoryRateBpm = respiratoryRateBpm;
        this.oxygenSaturationPercent = oxygenSaturationPercent;
        this.bloodGlucoseMgDl = bloodGlucoseMgDl;
        this.heightCm = heightCm;
        this.weightKg = weightKg;
        this.notes = notes;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public Long getPatientId() {
        return patientId;
    }

    public String getPatientCode() {
        return patientCode;
    }

    public String getPatientName() {
        return patientName;
    }

    public OffsetDateTime getRecordedAt() {
        return recordedAt;
    }

    public BigDecimal getTemperatureCelsius() {
        return temperatureCelsius;
    }

    public Integer getHeartRateBpm() {
        return heartRateBpm;
    }

    public Integer getSystolicBpMmhg() {
        return systolicBpMmhg;
    }

    public Integer getDiastolicBpMmhg() {
        return diastolicBpMmhg;
    }

    public Integer getRespiratoryRateBpm() {
        return respiratoryRateBpm;
    }

    public BigDecimal getOxygenSaturationPercent() {
        return oxygenSaturationPercent;
    }

    public BigDecimal getBloodGlucoseMgDl() {
        return bloodGlucoseMgDl;
    }

    public BigDecimal getHeightCm() {
        return heightCm;
    }

    public BigDecimal getWeightKg() {
        return weightKg;
    }

    public String getNotes() {
        return notes;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }
}

