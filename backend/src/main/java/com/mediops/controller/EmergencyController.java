package com.mediops.controller;

import com.mediops.dto.emergency.EmergencyCreateRequest;
import com.mediops.dto.emergency.EmergencyResponse;
import com.mediops.dto.emergency.EmergencyUpdateRequest;
import com.mediops.entity.Department;
import com.mediops.entity.Doctor;
import com.mediops.entity.Emergency;
import com.mediops.entity.Patient;
import com.mediops.service.DepartmentService;
import com.mediops.service.DoctorService;
import com.mediops.service.EmergencyService;
import com.mediops.service.PatientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/emergencies")
public class EmergencyController {

    private final EmergencyService emergencyService;
    private final PatientService patientService;
    private final DoctorService doctorService;
    private final DepartmentService departmentService;

    public EmergencyController(
            EmergencyService emergencyService,
            PatientService patientService,
            DoctorService doctorService,
            DepartmentService departmentService) {
        this.emergencyService = emergencyService;
        this.patientService = patientService;
        this.doctorService = doctorService;
        this.departmentService = departmentService;
    }

    @PostMapping
    public ResponseEntity<EmergencyResponse> create(
            @RequestBody EmergencyCreateRequest request) {

        Patient patient =
                patientService.getById(request.getPatientId());

        Doctor doctor = null;
        if (request.getDoctorId() != null) {
            doctor = doctorService.getById(request.getDoctorId());
        }

        Department department =
                departmentService.getById(request.getDepartmentId());

        Emergency emergency = new Emergency();

        emergency.setEmergencyCode(request.getEmergencyCode());
        emergency.setPatient(patient);
        emergency.setDoctor(doctor);
        emergency.setDepartment(department);
        emergency.setArrivalAt(request.getArrivalAt());
        emergency.setChiefComplaint(request.getChiefComplaint());
        emergency.setTriageLevel(request.getTriageLevel());
        emergency.setStatus(request.getStatus());
        emergency.setNotes(request.getNotes());

        OffsetDateTime now = OffsetDateTime.now();
        emergency.setCreatedAt(now);
        emergency.setUpdatedAt(now);

        Emergency createdEmergency =
                emergencyService.create(emergency);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(toResponse(createdEmergency));
    }

    @GetMapping
    public ResponseEntity<List<EmergencyResponse>> getAll() {

        List<EmergencyResponse> responses =
                emergencyService.getAll()
                        .stream()
                        .map(this::toResponse)
                        .toList();

        return ResponseEntity.ok(responses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmergencyResponse> getById(
            @PathVariable Long id) {

        Emergency emergency =
                emergencyService.getById(id);

        return ResponseEntity.ok(toResponse(emergency));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmergencyResponse> update(
            @PathVariable Long id,
            @RequestBody EmergencyUpdateRequest request) {

        Emergency emergency =
                emergencyService.getById(id);

        Patient patient =
                patientService.getById(request.getPatientId());

        Doctor doctor = null;
        if (request.getDoctorId() != null) {
            doctor = doctorService.getById(request.getDoctorId());
        }

        Department department =
                departmentService.getById(request.getDepartmentId());

        emergency.setEmergencyCode(request.getEmergencyCode());
        emergency.setPatient(patient);
        emergency.setDoctor(doctor);
        emergency.setDepartment(department);
        emergency.setArrivalAt(request.getArrivalAt());
        emergency.setChiefComplaint(request.getChiefComplaint());
        emergency.setTriageLevel(request.getTriageLevel());
        emergency.setStatus(request.getStatus());
        emergency.setNotes(request.getNotes());
        emergency.setUpdatedAt(OffsetDateTime.now());

        Emergency updatedEmergency =
                emergencyService.update(emergency);

        return ResponseEntity.ok(toResponse(updatedEmergency));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Long id) {

        emergencyService.getById(id);
        emergencyService.delete(id);

        return ResponseEntity.noContent().build();
    }

    private EmergencyResponse toResponse(Emergency emergency) {

        Patient patient = emergency.getPatient();
        Doctor doctor = emergency.getDoctor();
        Department department = emergency.getDepartment();

        String patientName =
                patient.getFirstName() + " " + patient.getLastName();

        Long doctorId = null;
        String doctorCode = null;
        String doctorName = null;

        if (doctor != null) {
            doctorId = doctor.getId();
            doctorCode = doctor.getDoctorCode();
            doctorName =
                    doctor.getFirstName() + " " + doctor.getLastName();
        }

        return new EmergencyResponse(
                emergency.getId(),
                emergency.getEmergencyCode(),
                patient.getId(),
                patient.getPatientCode(),
                patientName,
                doctorId,
                doctorCode,
                doctorName,
                department.getId(),
                department.getDepartmentCode(),
                department.getName(),
                emergency.getArrivalAt(),
                emergency.getChiefComplaint(),
                emergency.getTriageLevel(),
                emergency.getStatus(),
                emergency.getNotes(),
                emergency.getCreatedAt(),
                emergency.getUpdatedAt()
        );
    }
}