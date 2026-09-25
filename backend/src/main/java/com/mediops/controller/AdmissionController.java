package com.mediops.controller;

import com.mediops.dto.admission.AdmissionCreateRequest;
import com.mediops.dto.admission.AdmissionResponse;
import com.mediops.dto.admission.AdmissionUpdateRequest;
import com.mediops.entity.Admission;
import com.mediops.entity.Bed;
import com.mediops.entity.Doctor;
import com.mediops.entity.Emergency;
import com.mediops.entity.Patient;
import com.mediops.service.AdmissionService;
import com.mediops.service.BedService;
import com.mediops.service.DoctorService;
import com.mediops.service.EmergencyService;
import com.mediops.service.PatientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/admissions")
public class AdmissionController {

    private final AdmissionService admissionService;
    private final PatientService patientService;
    private final DoctorService doctorService;
    private final BedService bedService;
    private final EmergencyService emergencyService;

    public AdmissionController(
            AdmissionService admissionService,
            PatientService patientService,
            DoctorService doctorService,
            BedService bedService,
            EmergencyService emergencyService) {
        this.admissionService = admissionService;
        this.patientService = patientService;
        this.doctorService = doctorService;
        this.bedService = bedService;
        this.emergencyService = emergencyService;
    }

    @PostMapping
    public ResponseEntity<AdmissionResponse> create(
            @RequestBody AdmissionCreateRequest request) {

        Patient patient =
                patientService.getById(request.getPatientId());

        Doctor doctor =
                doctorService.getById(request.getDoctorId());

        Bed bed = null;
        if (request.getBedId() != null) {
            bed = bedService.getById(request.getBedId());
        }

        Emergency emergency = null;
        if (request.getEmergencyId() != null) {
            emergency = emergencyService.getById(request.getEmergencyId());
        }

        Admission admission = new Admission();

        admission.setAdmissionCode(request.getAdmissionCode());
        admission.setPatient(patient);
        admission.setDoctor(doctor);
        admission.setBed(bed);
        admission.setEmergency(emergency);
        admission.setAdmissionType(request.getAdmissionType());
        admission.setAdmittedAt(request.getAdmittedAt());
        admission.setExpectedDischargeAt(request.getExpectedDischargeAt());
        admission.setDischargedAt(request.getDischargedAt());
        admission.setDischargeSummary(request.getDischargeSummary());
        admission.setStatus(request.getStatus());
        admission.setNotes(request.getNotes());

        OffsetDateTime now = OffsetDateTime.now();
        admission.setCreatedAt(now);
        admission.setUpdatedAt(now);

        Admission createdAdmission =
                admissionService.create(admission);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(toResponse(createdAdmission));
    }

    @GetMapping
    public ResponseEntity<List<AdmissionResponse>> getAll() {

        List<AdmissionResponse> responses =
                admissionService.getAll()
                        .stream()
                        .map(this::toResponse)
                        .toList();

        return ResponseEntity.ok(responses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdmissionResponse> getById(
            @PathVariable Long id) {

        Admission admission =
                admissionService.getById(id);

        return ResponseEntity.ok(toResponse(admission));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AdmissionResponse> update(
            @PathVariable Long id,
            @RequestBody AdmissionUpdateRequest request) {

        Admission admission =
                admissionService.getById(id);

        Patient patient =
                patientService.getById(request.getPatientId());

        Doctor doctor =
                doctorService.getById(request.getDoctorId());

        Bed bed = null;
        if (request.getBedId() != null) {
            bed = bedService.getById(request.getBedId());
        }

        Emergency emergency = null;
        if (request.getEmergencyId() != null) {
            emergency = emergencyService.getById(request.getEmergencyId());
        }

        admission.setAdmissionCode(request.getAdmissionCode());
        admission.setPatient(patient);
        admission.setDoctor(doctor);
        admission.setBed(bed);
        admission.setEmergency(emergency);
        admission.setAdmissionType(request.getAdmissionType());
        admission.setAdmittedAt(request.getAdmittedAt());
        admission.setExpectedDischargeAt(request.getExpectedDischargeAt());
        admission.setDischargedAt(request.getDischargedAt());
        admission.setDischargeSummary(request.getDischargeSummary());
        admission.setStatus(request.getStatus());
        admission.setNotes(request.getNotes());
        admission.setUpdatedAt(OffsetDateTime.now());

        Admission updatedAdmission =
                admissionService.update(admission);

        return ResponseEntity.ok(toResponse(updatedAdmission));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Long id) {

        admissionService.getById(id);
        admissionService.delete(id);

        return ResponseEntity.noContent().build();
    }

    private AdmissionResponse toResponse(Admission admission) {

        Patient patient = admission.getPatient();
        Doctor doctor = admission.getDoctor();
        Bed bed = admission.getBed();
        Emergency emergency = admission.getEmergency();

        String patientName =
                patient.getFirstName() + " " + patient.getLastName();

        String doctorName =
                doctor.getFirstName() + " " + doctor.getLastName();

        Long bedId = null;
        String bedCode = null;

        if (bed != null) {
            bedId = bed.getId();
            bedCode = bed.getBedCode();
        }

        Long emergencyId = null;
        String emergencyCode = null;

        if (emergency != null) {
            emergencyId = emergency.getId();
            emergencyCode = emergency.getEmergencyCode();
        }

        return new AdmissionResponse(
                admission.getId(),
                admission.getAdmissionCode(),
                patient.getId(),
                patient.getPatientCode(),
                patientName,
                doctor.getId(),
                doctor.getDoctorCode(),
                doctorName,
                bedId,
                bedCode,
                emergencyId,
                emergencyCode,
                admission.getAdmissionType(),
                admission.getAdmittedAt(),
                admission.getExpectedDischargeAt(),
                admission.getDischargedAt(),
                admission.getDischargeSummary(),
                admission.getStatus(),
                admission.getNotes(),
                admission.getCreatedAt(),
                admission.getUpdatedAt()
        );
    }
}