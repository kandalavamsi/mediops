package com.mediops.dto.emergency;

import java.time.OffsetDateTime;

public class EmergencyResponse {

    private Long id;
    private String emergencyCode;

    private Long patientId;
    private String patientCode;
    private String patientName;

    private Long doctorId;
    private String doctorCode;
    private String doctorName;

    private Long departmentId;
    private String departmentCode;
    private String departmentName;

    private OffsetDateTime arrivalAt;
    private String chiefComplaint;
    private String triageLevel;
    private String status;
    private String notes;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;

    public EmergencyResponse(
            Long id,
            String emergencyCode,
            Long patientId,
            String patientCode,
            String patientName,
            Long doctorId,
            String doctorCode,
            String doctorName,
            Long departmentId,
            String departmentCode,
            String departmentName,
            OffsetDateTime arrivalAt,
            String chiefComplaint,
            String triageLevel,
            String status,
            String notes,
            OffsetDateTime createdAt,
            OffsetDateTime updatedAt) {

        this.id = id;
        this.emergencyCode = emergencyCode;
        this.patientId = patientId;
        this.patientCode = patientCode;
        this.patientName = patientName;
        this.doctorId = doctorId;
        this.doctorCode = doctorCode;
        this.doctorName = doctorName;
        this.departmentId = departmentId;
        this.departmentCode = departmentCode;
        this.departmentName = departmentName;
        this.arrivalAt = arrivalAt;
        this.chiefComplaint = chiefComplaint;
        this.triageLevel = triageLevel;
        this.status = status;
        this.notes = notes;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public String getEmergencyCode() {
        return emergencyCode;
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

    public Long getDepartmentId() {
        return departmentId;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public OffsetDateTime getArrivalAt() {
        return arrivalAt;
    }

    public String getChiefComplaint() {
        return chiefComplaint;
    }

    public String getTriageLevel() {
        return triageLevel;
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