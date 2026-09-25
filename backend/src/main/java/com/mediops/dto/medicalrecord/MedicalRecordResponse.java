package com.mediops.dto.medicalrecord;

import java.time.OffsetDateTime;

public class MedicalRecordResponse {

    private Long id;
    private String recordCode;

    private Long patientId;
    private String patientCode;
    private String patientName;

    private Long doctorId;
    private String doctorCode;
    private String doctorName;

    private Long appointmentId;
    private String appointmentCode;

    private String recordType;
    private OffsetDateTime recordedAt;
    private String chiefComplaint;
    private String symptoms;
    private String examinationNotes;
    private String diagnosis;
    private String treatmentPlan;
    private String clinicalNotes;

    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;

    public MedicalRecordResponse(
            Long id,
            String recordCode,
            Long patientId,
            String patientCode,
            String patientName,
            Long doctorId,
            String doctorCode,
            String doctorName,
            Long appointmentId,
            String appointmentCode,
            String recordType,
            OffsetDateTime recordedAt,
            String chiefComplaint,
            String symptoms,
            String examinationNotes,
            String diagnosis,
            String treatmentPlan,
            String clinicalNotes,
            OffsetDateTime createdAt,
            OffsetDateTime updatedAt) {

        this.id = id;
        this.recordCode = recordCode;
        this.patientId = patientId;
        this.patientCode = patientCode;
        this.patientName = patientName;
        this.doctorId = doctorId;
        this.doctorCode = doctorCode;
        this.doctorName = doctorName;
        this.appointmentId = appointmentId;
        this.appointmentCode = appointmentCode;
        this.recordType = recordType;
        this.recordedAt = recordedAt;
        this.chiefComplaint = chiefComplaint;
        this.symptoms = symptoms;
        this.examinationNotes = examinationNotes;
        this.diagnosis = diagnosis;
        this.treatmentPlan = treatmentPlan;
        this.clinicalNotes = clinicalNotes;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public String getRecordCode() {
        return recordCode;
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

    public Long getAppointmentId() {
        return appointmentId;
    }

    public String getAppointmentCode() {
        return appointmentCode;
    }

    public String getRecordType() {
        return recordType;
    }

    public OffsetDateTime getRecordedAt() {
        return recordedAt;
    }

    public String getChiefComplaint() {
        return chiefComplaint;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public String getExaminationNotes() {
        return examinationNotes;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public String getTreatmentPlan() {
        return treatmentPlan;
    }

    public String getClinicalNotes() {
        return clinicalNotes;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public OffsetDateTime getUpdatedAt() {
        return updatedAt;
    }
}