package com.mediops.controller;

import com.mediops.dto.medicalrecord.MedicalRecordCreateRequest;
import com.mediops.dto.medicalrecord.MedicalRecordResponse;
import com.mediops.dto.medicalrecord.MedicalRecordUpdateRequest;
import com.mediops.entity.Appointment;
import com.mediops.entity.Doctor;
import com.mediops.entity.MedicalRecord;
import com.mediops.entity.Patient;
import com.mediops.service.AppointmentService;
import com.mediops.service.DoctorService;
import com.mediops.service.MedicalRecordService;
import com.mediops.service.PatientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/medical-records")
public class MedicalRecordController {

    private final MedicalRecordService medicalRecordService;
    private final PatientService patientService;
    private final DoctorService doctorService;
    private final AppointmentService appointmentService;

    public MedicalRecordController(
            MedicalRecordService medicalRecordService,
            PatientService patientService,
            DoctorService doctorService,
            AppointmentService appointmentService) {

        this.medicalRecordService = medicalRecordService;
        this.patientService = patientService;
        this.doctorService = doctorService;
        this.appointmentService = appointmentService;
    }

    @PostMapping
    public ResponseEntity<MedicalRecordResponse> create(
            @RequestBody MedicalRecordCreateRequest request) {

        Patient patient = patientService.getById(request.getPatientId());
        Doctor doctor = doctorService.getById(request.getDoctorId());

        Appointment appointment = null;

        if (request.getAppointmentId() != null) {
            appointment = appointmentService.getById(request.getAppointmentId());
        }

        MedicalRecord medicalRecord = new MedicalRecord();

        medicalRecord.setRecordCode(request.getRecordCode());
        medicalRecord.setPatient(patient);
        medicalRecord.setDoctor(doctor);
        medicalRecord.setAppointment(appointment);
        medicalRecord.setRecordType(request.getRecordType());
        medicalRecord.setRecordedAt(request.getRecordedAt());
        medicalRecord.setChiefComplaint(request.getChiefComplaint());
        medicalRecord.setSymptoms(request.getSymptoms());
        medicalRecord.setExaminationNotes(request.getExaminationNotes());
        medicalRecord.setDiagnosis(request.getDiagnosis());
        medicalRecord.setTreatmentPlan(request.getTreatmentPlan());
        medicalRecord.setClinicalNotes(request.getClinicalNotes());

        OffsetDateTime now = OffsetDateTime.now();
        medicalRecord.setCreatedAt(now);
        medicalRecord.setUpdatedAt(now);

        MedicalRecord createdMedicalRecord =
                medicalRecordService.create(medicalRecord);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(toResponse(createdMedicalRecord));
    }

    @GetMapping
    public ResponseEntity<List<MedicalRecordResponse>> getAll() {

        List<MedicalRecordResponse> responses =
                medicalRecordService.getAll()
                        .stream()
                        .map(this::toResponse)
                        .toList();

        return ResponseEntity.ok(responses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicalRecordResponse> getById(
            @PathVariable Long id) {

        MedicalRecord medicalRecord =
                medicalRecordService.getById(id);

        return ResponseEntity.ok(toResponse(medicalRecord));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MedicalRecordResponse> update(
            @PathVariable Long id,
            @RequestBody MedicalRecordUpdateRequest request) {

        MedicalRecord medicalRecord =
                medicalRecordService.getById(id);

        Patient patient =
                patientService.getById(request.getPatientId());

        Doctor doctor =
                doctorService.getById(request.getDoctorId());

        Appointment appointment = null;

        if (request.getAppointmentId() != null) {
            appointment =
                    appointmentService.getById(request.getAppointmentId());
        }

        medicalRecord.setRecordCode(request.getRecordCode());
        medicalRecord.setPatient(patient);
        medicalRecord.setDoctor(doctor);
        medicalRecord.setAppointment(appointment);
        medicalRecord.setRecordType(request.getRecordType());
        medicalRecord.setRecordedAt(request.getRecordedAt());
        medicalRecord.setChiefComplaint(request.getChiefComplaint());
        medicalRecord.setSymptoms(request.getSymptoms());
        medicalRecord.setExaminationNotes(request.getExaminationNotes());
        medicalRecord.setDiagnosis(request.getDiagnosis());
        medicalRecord.setTreatmentPlan(request.getTreatmentPlan());
        medicalRecord.setClinicalNotes(request.getClinicalNotes());
        medicalRecord.setUpdatedAt(OffsetDateTime.now());

        MedicalRecord updatedMedicalRecord =
                medicalRecordService.update(medicalRecord);

        return ResponseEntity.ok(toResponse(updatedMedicalRecord));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Long id) {

        medicalRecordService.getById(id);
        medicalRecordService.delete(id);

        return ResponseEntity.noContent().build();
    }

    private MedicalRecordResponse toResponse(
            MedicalRecord medicalRecord) {

        Patient patient = medicalRecord.getPatient();
        Doctor doctor = medicalRecord.getDoctor();
        Appointment appointment = medicalRecord.getAppointment();

        String patientName =
                patient.getFirstName() + " " + patient.getLastName();

        String doctorName =
                doctor.getFirstName() + " " + doctor.getLastName();

        Long appointmentId = null;
        String appointmentCode = null;

        if (appointment != null) {
            appointmentId = appointment.getId();
            appointmentCode = appointment.getAppointmentCode();
        }

        return new MedicalRecordResponse(
                medicalRecord.getId(),
                medicalRecord.getRecordCode(),

                patient.getId(),
                patient.getPatientCode(),
                patientName,

                doctor.getId(),
                doctor.getDoctorCode(),
                doctorName,

                appointmentId,
                appointmentCode,

                medicalRecord.getRecordType(),
                medicalRecord.getRecordedAt(),
                medicalRecord.getChiefComplaint(),
                medicalRecord.getSymptoms(),
                medicalRecord.getExaminationNotes(),
                medicalRecord.getDiagnosis(),
                medicalRecord.getTreatmentPlan(),
                medicalRecord.getClinicalNotes(),

                medicalRecord.getCreatedAt(),
                medicalRecord.getUpdatedAt()
        );
    }
}