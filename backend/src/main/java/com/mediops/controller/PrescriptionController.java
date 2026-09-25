package com.mediops.controller;

import com.mediops.dto.prescription.PrescriptionCreateRequest;
import com.mediops.dto.prescription.PrescriptionResponse;
import com.mediops.dto.prescription.PrescriptionUpdateRequest;
import com.mediops.entity.Doctor;
import com.mediops.entity.MedicalRecord;
import com.mediops.entity.Patient;
import com.mediops.entity.Prescription;
import com.mediops.service.DoctorService;
import com.mediops.service.MedicalRecordService;
import com.mediops.service.PatientService;
import com.mediops.service.PrescriptionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/prescriptions")
public class PrescriptionController {

    private final PrescriptionService prescriptionService;
    private final PatientService patientService;
    private final DoctorService doctorService;
    private final MedicalRecordService medicalRecordService;

    public PrescriptionController(
            PrescriptionService prescriptionService,
            PatientService patientService,
            DoctorService doctorService,
            MedicalRecordService medicalRecordService) {
        this.prescriptionService = prescriptionService;
        this.patientService = patientService;
        this.doctorService = doctorService;
        this.medicalRecordService = medicalRecordService;
    }

    @PostMapping
    public ResponseEntity<PrescriptionResponse> create(
            @RequestBody PrescriptionCreateRequest request) {

        Patient patient =
                patientService.getById(request.getPatientId());

        Doctor doctor =
                doctorService.getById(request.getDoctorId());

        MedicalRecord medicalRecord = null;

        if (request.getMedicalRecordId() != null) {
            medicalRecord =
                    medicalRecordService.getById(request.getMedicalRecordId());
        }

        Prescription prescription = new Prescription();

        prescription.setPrescriptionCode(request.getPrescriptionCode());
        prescription.setPatient(patient);
        prescription.setDoctor(doctor);
        prescription.setMedicalRecord(medicalRecord);
        prescription.setMedicationName(request.getMedicationName());
        prescription.setDosage(request.getDosage());
        prescription.setFrequency(request.getFrequency());
        prescription.setRoute(request.getRoute());
        prescription.setDurationDays(request.getDurationDays());
        prescription.setQuantity(request.getQuantity());
        prescription.setInstructions(request.getInstructions());
        prescription.setPrescribedAt(request.getPrescribedAt());
        prescription.setStatus(request.getStatus());
        prescription.setCreatedAt(OffsetDateTime.now());
        prescription.setUpdatedAt(OffsetDateTime.now());

        Prescription createdPrescription =
                prescriptionService.create(prescription);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(toResponse(createdPrescription));
    }

    @GetMapping
    public ResponseEntity<List<PrescriptionResponse>> getAll() {

        List<PrescriptionResponse> responses =
                prescriptionService.getAll()
                        .stream()
                        .map(this::toResponse)
                        .toList();

        return ResponseEntity.ok(responses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PrescriptionResponse> getById(
            @PathVariable Long id) {

        Prescription prescription =
                prescriptionService.getById(id);

        return ResponseEntity.ok(toResponse(prescription));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PrescriptionResponse> update(
            @PathVariable Long id,
            @RequestBody PrescriptionUpdateRequest request) {

        Prescription prescription =
                prescriptionService.getById(id);

        Patient patient =
                patientService.getById(request.getPatientId());

        Doctor doctor =
                doctorService.getById(request.getDoctorId());

        MedicalRecord medicalRecord = null;

        if (request.getMedicalRecordId() != null) {
            medicalRecord =
                    medicalRecordService.getById(request.getMedicalRecordId());
        }

        prescription.setPrescriptionCode(request.getPrescriptionCode());
        prescription.setPatient(patient);
        prescription.setDoctor(doctor);
        prescription.setMedicalRecord(medicalRecord);
        prescription.setMedicationName(request.getMedicationName());
        prescription.setDosage(request.getDosage());
        prescription.setFrequency(request.getFrequency());
        prescription.setRoute(request.getRoute());
        prescription.setDurationDays(request.getDurationDays());
        prescription.setQuantity(request.getQuantity());
        prescription.setInstructions(request.getInstructions());
        prescription.setPrescribedAt(request.getPrescribedAt());
        prescription.setStatus(request.getStatus());
        prescription.setUpdatedAt(OffsetDateTime.now());

        Prescription updatedPrescription =
                prescriptionService.update(prescription);

        return ResponseEntity.ok(toResponse(updatedPrescription));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Long id) {

        prescriptionService.getById(id);
        prescriptionService.delete(id);

        return ResponseEntity.noContent().build();
    }

    private PrescriptionResponse toResponse(
            Prescription prescription) {

        Patient patient = prescription.getPatient();
        Doctor doctor = prescription.getDoctor();
        MedicalRecord medicalRecord =
                prescription.getMedicalRecord();

        String patientName =
                patient.getFirstName() + " " + patient.getLastName();

        String doctorName =
                doctor.getFirstName() + " " + doctor.getLastName();

        Long medicalRecordId = null;
        String recordCode = null;

        if (medicalRecord != null) {
            medicalRecordId = medicalRecord.getId();
            recordCode = medicalRecord.getRecordCode();
        }

        return new PrescriptionResponse(
                prescription.getId(),
                prescription.getPrescriptionCode(),
                patient.getId(),
                patient.getPatientCode(),
                patientName,
                doctor.getId(),
                doctor.getDoctorCode(),
                doctorName,
                medicalRecordId,
                recordCode,
                prescription.getMedicationName(),
                prescription.getDosage(),
                prescription.getFrequency(),
                prescription.getRoute(),
                prescription.getDurationDays(),
                prescription.getQuantity(),
                prescription.getInstructions(),
                prescription.getPrescribedAt(),
                prescription.getStatus(),
                prescription.getCreatedAt(),
                prescription.getUpdatedAt()
        );
    }
}