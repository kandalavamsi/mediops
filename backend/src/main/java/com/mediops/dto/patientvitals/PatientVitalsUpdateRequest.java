
package com.mediops.dto.patientvitals;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class PatientVitalsUpdateRequest {

    private Long patientId;
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

    public PatientVitalsUpdateRequest() {
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
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
}

