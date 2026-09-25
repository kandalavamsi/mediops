package com.mediops.dto.prescription;

import java.time.OffsetDateTime;

public class PrescriptionUpdateRequest {

    private String prescriptionCode;
    private Long patientId;
    private Long doctorId;
    private Long medicalRecordId;
    private String medicationName;
    private String dosage;
    private String frequency;
    private String route;
    private Integer durationDays;
    private String quantity;
    private String instructions;
    private OffsetDateTime prescribedAt;
    private String status;

    public PrescriptionUpdateRequest() {
    }

    public String getPrescriptionCode() {
        return prescriptionCode;
    }

    public Long getPatientId() {
        return patientId;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public Long getMedicalRecordId() {
        return medicalRecordId;
    }

    public String getMedicationName() {
        return medicationName;
    }

    public String getDosage() {
        return dosage;
    }

    public String getFrequency() {
        return frequency;
    }

    public String getRoute() {
        return route;
    }

    public Integer getDurationDays() {
        return durationDays;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getInstructions() {
        return instructions;
    }

    public OffsetDateTime getPrescribedAt() {
        return prescribedAt;
    }

    public String getStatus() {
        return status;
    }
}