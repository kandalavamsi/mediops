package com.mediops.dto.admission;

import java.time.OffsetDateTime;

public class AdmissionResponse {

    private Long id;
    private String admissionCode;

    private Long patientId;
    private String patientCode;
    private String patientName;

    private Long doctorId;
    private String doctorCode;
    private String doctorName;

    private Long bedId;
    private String bedCode;

    private Long emergencyId;
    private String emergencyCode;

    private String admissionType;
    private OffsetDateTime admittedAt;
    private OffsetDateTime expectedDischargeAt;
    private OffsetDateTime dischargedAt;
    private String dischargeSummary;
    private String status;
    private String notes;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;

    public AdmissionResponse(
            Long id,
            String admissionCode,
            Long patientId,
            String patientCode,
            String patientName,
            Long doctorId,
            String doctorCode,
            String doctorName,
            Long bedId,
            String bedCode,
            Long emergencyId,
            String emergencyCode,
            String admissionType,
            OffsetDateTime admittedAt,
            OffsetDateTime expectedDischargeAt,
            OffsetDateTime dischargedAt,
            String dischargeSummary,
            String status,
            String notes,
            OffsetDateTime createdAt,
            OffsetDateTime updatedAt) {

        this.id = id;
        this.admissionCode = admissionCode;
        this.patientId = patientId;
        this.patientCode = patientCode;
        this.patientName = patientName;
        this.doctorId = doctorId;
        this.doctorCode = doctorCode;
        this.doctorName = doctorName;
        this.bedId = bedId;
        this.bedCode = bedCode;
        this.emergencyId = emergencyId;
        this.emergencyCode = emergencyCode;
        this.admissionType = admissionType;
        this.admittedAt = admittedAt;
        this.expectedDischargeAt = expectedDischargeAt;
        this.dischargedAt = dischargedAt;
        this.dischargeSummary = dischargeSummary;
        this.status = status;
        this.notes = notes;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public String getAdmissionCode() {
        return admissionCode;
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

    public Long getBedId() {
        return bedId;
    }

    public String getBedCode() {
        return bedCode;
    }

    public Long getEmergencyId() {
        return emergencyId;
    }

    public String getEmergencyCode() {
        return emergencyCode;
    }

    public String getAdmissionType() {
        return admissionType;
    }

    public OffsetDateTime getAdmittedAt() {
        return admittedAt;
    }

    public OffsetDateTime getExpectedDischargeAt() {
        return expectedDischargeAt;
    }

    public OffsetDateTime getDischargedAt() {
        return dischargedAt;
    }

    public String getDischargeSummary() {
        return dischargeSummary;
    }

    public String getStatus() {
        return status;
    }

    public String getNotes() {
        return notes;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public OffsetDateTime getUpdatedAt() {
        return updatedAt;
    }
}