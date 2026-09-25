package com.mediops.controller;

import com.mediops.dto.patient.PatientCreateRequest;
import com.mediops.dto.patient.PatientResponse;
import com.mediops.dto.patient.PatientUpdateRequest;
import com.mediops.entity.Patient;
import com.mediops.service.PatientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/patients")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping
    public ResponseEntity<PatientResponse> create(
            @RequestBody PatientCreateRequest request) {

        Patient patient = new Patient();

        patient.setPatientCode(request.getPatientCode());
        patient.setFirstName(request.getFirstName());
        patient.setMiddleName(request.getMiddleName());
        patient.setLastName(request.getLastName());
        patient.setDateOfBirth(request.getDateOfBirth());
        patient.setGender(request.getGender());
        patient.setBloodGroup(request.getBloodGroup());
        patient.setPhone(request.getPhone());
        patient.setAlternatePhone(request.getAlternatePhone());
        patient.setEmail(request.getEmail());
        patient.setAddressLine1(request.getAddressLine1());
        patient.setAddressLine2(request.getAddressLine2());
        patient.setCity(request.getCity());
        patient.setState(request.getState());
        patient.setPostalCode(request.getPostalCode());
        patient.setCountry(request.getCountry());
        patient.setEmergencyContactName(request.getEmergencyContactName());
        patient.setEmergencyContactPhone(request.getEmergencyContactPhone());
        patient.setEmergencyContactRelationship(
                request.getEmergencyContactRelationship()
        );
        patient.setStatus(request.getStatus());

        OffsetDateTime now = OffsetDateTime.now();
        patient.setCreatedAt(now);
        patient.setUpdatedAt(now);

        Patient savedPatient = patientService.create(patient);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(toResponse(savedPatient));
    }

    @GetMapping
    public ResponseEntity<List<PatientResponse>> getAll() {

        List<PatientResponse> patients = patientService.getAll()
                .stream()
                .map(this::toResponse)
                .toList();

        return ResponseEntity.ok(patients);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientResponse> getById(
            @PathVariable Long id) {

        Patient patient = patientService.getById(id);

        return ResponseEntity.ok(toResponse(patient));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatientResponse> update(
            @PathVariable Long id,
            @RequestBody PatientUpdateRequest request) {

        Patient patient = patientService.getById(id);

        patient.setPatientCode(request.getPatientCode());
        patient.setFirstName(request.getFirstName());
        patient.setMiddleName(request.getMiddleName());
        patient.setLastName(request.getLastName());
        patient.setDateOfBirth(request.getDateOfBirth());
        patient.setGender(request.getGender());
        patient.setBloodGroup(request.getBloodGroup());
        patient.setPhone(request.getPhone());
        patient.setAlternatePhone(request.getAlternatePhone());
        patient.setEmail(request.getEmail());
        patient.setAddressLine1(request.getAddressLine1());
        patient.setAddressLine2(request.getAddressLine2());
        patient.setCity(request.getCity());
        patient.setState(request.getState());
        patient.setPostalCode(request.getPostalCode());
        patient.setCountry(request.getCountry());
        patient.setEmergencyContactName(request.getEmergencyContactName());
        patient.setEmergencyContactPhone(request.getEmergencyContactPhone());
        patient.setEmergencyContactRelationship(
                request.getEmergencyContactRelationship()
        );
        patient.setStatus(request.getStatus());
        patient.setUpdatedAt(OffsetDateTime.now());

        Patient updatedPatient = patientService.update(patient);

        return ResponseEntity.ok(toResponse(updatedPatient));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Long id) {

        patientService.getById(id);
        patientService.delete(id);

        return ResponseEntity.noContent().build();
    }

    private PatientResponse toResponse(Patient patient) {

        return new PatientResponse(
                patient.getId(),
                patient.getPatientCode(),
                patient.getFirstName(),
                patient.getMiddleName(),
                patient.getLastName(),
                patient.getDateOfBirth(),
                patient.getGender(),
                patient.getBloodGroup(),
                patient.getPhone(),
                patient.getAlternatePhone(),
                patient.getEmail(),
                patient.getAddressLine1(),
                patient.getAddressLine2(),
                patient.getCity(),
                patient.getState(),
                patient.getPostalCode(),
                patient.getCountry(),
                patient.getEmergencyContactName(),
                patient.getEmergencyContactPhone(),
                patient.getEmergencyContactRelationship(),
                patient.getStatus(),
                patient.getCreatedAt(),
                patient.getUpdatedAt()
        );
    }
}