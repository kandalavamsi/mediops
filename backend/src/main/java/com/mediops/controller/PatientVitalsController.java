
package com.mediops.controller;

import com.mediops.dto.patientvitals.PatientVitalsCreateRequest;
import com.mediops.dto.patientvitals.PatientVitalsResponse;
import com.mediops.dto.patientvitals.PatientVitalsUpdateRequest;
import com.mediops.entity.Patient;
import com.mediops.entity.PatientVitals;
import com.mediops.service.PatientService;
import com.mediops.service.PatientVitalsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/patient-vitals")
public class PatientVitalsController {

    private final PatientVitalsService patientVitalsService;
    private final PatientService patientService;

    public PatientVitalsController(
            PatientVitalsService patientVitalsService,
            PatientService patientService) {
        this.patientVitalsService = patientVitalsService;
        this.patientService = patientService;
    }

    @PostMapping
    public ResponseEntity<PatientVitalsResponse> create(
            @RequestBody PatientVitalsCreateRequest request) {

        Patient patient =
                patientService.getById(request.getPatientId());

        PatientVitals patientVitals = new PatientVitals();

        patientVitals.setPatient(patient);
        patientVitals.setRecordedAt(request.getRecordedAt());
        patientVitals.setTemperatureCelsius(
                request.getTemperatureCelsius());
        patientVitals.setHeartRateBpm(
                request.getHeartRateBpm());
        patientVitals.setSystolicBpMmhg(
                request.getSystolicBpMmhg());
        patientVitals.setDiastolicBpMmhg(
                request.getDiastolicBpMmhg());
        patientVitals.setRespiratoryRateBpm(
                request.getRespiratoryRateBpm());
        patientVitals.setOxygenSaturationPercent(
                request.getOxygenSaturationPercent());
        patientVitals.setBloodGlucoseMgDl(
                request.getBloodGlucoseMgDl());
        patientVitals.setHeightCm(
                request.getHeightCm());
        patientVitals.setWeightKg(
                request.getWeightKg());
        patientVitals.setNotes(request.getNotes());
        patientVitals.setCreatedAt(OffsetDateTime.now());

        PatientVitals createdPatientVitals =
                patientVitalsService.create(patientVitals);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(toResponse(createdPatientVitals));
    }

    @GetMapping
    public ResponseEntity<List<PatientVitalsResponse>> getAll() {

        List<PatientVitalsResponse> responses =
                patientVitalsService.getAll()
                        .stream()
                        .map(this::toResponse)
                        .toList();

        return ResponseEntity.ok(responses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientVitalsResponse> getById(
            @PathVariable Long id) {

        PatientVitals patientVitals =
                patientVitalsService.getById(id);

        return ResponseEntity.ok(toResponse(patientVitals));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatientVitalsResponse> update(
            @PathVariable Long id,
            @RequestBody PatientVitalsUpdateRequest request) {

        PatientVitals patientVitals =
                patientVitalsService.getById(id);

        Patient patient =
                patientService.getById(request.getPatientId());

        patientVitals.setPatient(patient);
        patientVitals.setRecordedAt(request.getRecordedAt());
        patientVitals.setTemperatureCelsius(
                request.getTemperatureCelsius());
        patientVitals.setHeartRateBpm(
                request.getHeartRateBpm());
        patientVitals.setSystolicBpMmhg(
                request.getSystolicBpMmhg());
        patientVitals.setDiastolicBpMmhg(
                request.getDiastolicBpMmhg());
        patientVitals.setRespiratoryRateBpm(
                request.getRespiratoryRateBpm());
        patientVitals.setOxygenSaturationPercent(
                request.getOxygenSaturationPercent());
        patientVitals.setBloodGlucoseMgDl(
                request.getBloodGlucoseMgDl());
        patientVitals.setHeightCm(
                request.getHeightCm());
        patientVitals.setWeightKg(
                request.getWeightKg());
        patientVitals.setNotes(request.getNotes());

        PatientVitals updatedPatientVitals =
                patientVitalsService.update(patientVitals);

        return ResponseEntity.ok(toResponse(updatedPatientVitals));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Long id) {

        patientVitalsService.getById(id);
        patientVitalsService.delete(id);

        return ResponseEntity.noContent().build();
    }

    private PatientVitalsResponse toResponse(
            PatientVitals patientVitals) {

        Patient patient = patientVitals.getPatient();

        String patientName =
                patient.getFirstName() + " " + patient.getLastName();

        return new PatientVitalsResponse(
                patientVitals.getId(),
                patient.getId(),
                patient.getPatientCode(),
                patientName,
                patientVitals.getRecordedAt(),
                patientVitals.getTemperatureCelsius(),
                patientVitals.getHeartRateBpm(),
                patientVitals.getSystolicBpMmhg(),
                patientVitals.getDiastolicBpMmhg(),
                patientVitals.getRespiratoryRateBpm(),
                patientVitals.getOxygenSaturationPercent(),
                patientVitals.getBloodGlucoseMgDl(),
                patientVitals.getHeightCm(),
                patientVitals.getWeightKg(),
                patientVitals.getNotes(),
                patientVitals.getCreatedAt()
        );
    }
}
