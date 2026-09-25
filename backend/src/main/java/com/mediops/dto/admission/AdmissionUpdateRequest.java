package com.mediops.dto.admission;

import java.time.OffsetDateTime;

public class AdmissionUpdateRequest {

    private String admissionCode;
    private Long patientId;
    private Long doctorId;
    private Long bedId;
    private Long emergencyId;
    private String admissionType;
    private OffsetDateTime admittedAt;
    private OffsetDateTime expectedDischargeAt;
    private OffsetDateTime dischargedAt;
    private String dischargeSummary;
    private String status;
    private String notes;

    public AdmissionUpdateRequest() {
    }

    public String getAdmissionCode() {
        return admissionCode;
    }

    public Long getPatientId() {
        return patientId;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public Long getBedId() {
        return bedId;
    }

    public Long getEmergencyId() {
        return emergencyId;
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
}