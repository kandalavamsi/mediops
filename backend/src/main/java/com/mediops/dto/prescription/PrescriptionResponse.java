package com.mediops.dto.prescription;

import java.time.OffsetDateTime;

public class PrescriptionResponse {

    private Long id;
    private String prescriptionCode;

    private Long patientId;
    private String patientCode;
    private String patientName;

    private Long doctorId;
    private String doctorCode;
    private String doctorName;

    private Long medicalRecordId;
    private String recordCode;

    private String medicationName;
    private String dosage;
    private String frequency;
    private String route;
    private Integer durationDays;
    private String quantity;
    private String instructions;
    private OffsetDateTime prescribedAt;
    private String status;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;

    public PrescriptionResponse(
            Long id,
            String prescriptionCode,
            Long patientId,
            String patientCode,
            String patientName,
            Long doctorId,
            String doctorCode,
            String doctorName,
            Long medicalRecordId,
            String recordCode,
            String medicationName,
            String dosage,
            String frequency,
            String route,
            Integer durationDays,
            String quantity,
            String instructions,
            OffsetDateTime prescribedAt,
            String status,
            OffsetDateTime createdAt,
            OffsetDateTime updatedAt) {

        this.id = id;
        this.prescriptionCode = prescriptionCode;
        this.patientId = patientId;
        this.patientCode = patientCode;
        this.patientName = patientName;
        this.doctorId = doctorId;
        this.doctorCode = doctorCode;
        this.doctorName = doctorName;
        this.medicalRecordId = medicalRecordId;
        this.recordCode = recordCode;
        this.medicationName = medicationName;
        this.dosage = dosage;
        this.frequency = frequency;
        this.route = route;
        this.durationDays = durationDays;
        this.quantity = quantity;
        this.instructions = instructions;
        this.prescribedAt = prescribedAt;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public String getPrescriptionCode() {
        return prescriptionCode;
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

    public Long getDoctorId() {
        return doctorId;
    }

    public String getDoctorCode() {
        return doctorCode;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public Long getMedicalRecordId() {
        return medicalRecordId;
    }

    public String getRecordCode() {
        return recordCode;
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

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public OffsetDateTime getUpdatedAt() {
        return updatedAt;
    }
}