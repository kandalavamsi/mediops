package com.mediops.dto.appointment;

import java.time.OffsetDateTime;

public class AppointmentResponse {

    private Long id;
    private String appointmentCode;

    private Long patientId;
    private String patientCode;
    private String patientName;

    private Long doctorId;
    private String doctorCode;
    private String doctorName;

    private Long departmentId;
    private String departmentCode;
    private String departmentName;

    private OffsetDateTime startAt;
    private OffsetDateTime endAt;
    private String reason;
    private String notes;
    private String status;

    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;

    public AppointmentResponse() {
    }

    public AppointmentResponse(
            Long id,
            String appointmentCode,
            Long patientId,
            String patientCode,
            String patientName,
            Long doctorId,
            String doctorCode,
            String doctorName,
            Long departmentId,
            String departmentCode,
            String departmentName,
            OffsetDateTime startAt,
            OffsetDateTime endAt,
            String reason,
            String notes,
            String status,
            OffsetDateTime createdAt,
            OffsetDateTime updatedAt) {

        this.id = id;
        this.appointmentCode = appointmentCode;
        this.patientId = patientId;
        this.patientCode = patientCode;
        this.patientName = patientName;
        this.doctorId = doctorId;
        this.doctorCode = doctorCode;
        this.doctorName = doctorName;
        this.departmentId = departmentId;
        this.departmentCode = departmentCode;
        this.departmentName = departmentName;
        this.startAt = startAt;
        this.endAt = endAt;
        this.reason = reason;
        this.notes = notes;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public String getAppointmentCode() {
        return appointmentCode;
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

    public OffsetDateTime getStartAt() {
        return startAt;
    }

    public OffsetDateTime getEndAt() {
        return endAt;
    }

    public String getReason() {
        return reason;
    }

    public String getNotes() {
        return notes;
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