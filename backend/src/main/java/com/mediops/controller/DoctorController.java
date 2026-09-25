package com.mediops.controller;

import com.mediops.dto.doctor.DoctorCreateRequest;
import com.mediops.dto.doctor.DoctorResponse;
import com.mediops.dto.doctor.DoctorUpdateRequest;
import com.mediops.entity.Department;
import com.mediops.entity.Doctor;
import com.mediops.service.DepartmentService;
import com.mediops.service.DoctorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/doctors")
public class DoctorController {

    private final DoctorService doctorService;
    private final DepartmentService departmentService;

    public DoctorController(
            DoctorService doctorService,
            DepartmentService departmentService) {
        this.doctorService = doctorService;
        this.departmentService = departmentService;
    }

    @PostMapping
    public ResponseEntity<DoctorResponse> create(
            @RequestBody DoctorCreateRequest request) {

        Department department =
                departmentService.getById(request.getDepartmentId());

        Doctor doctor = new Doctor();

        doctor.setDoctorCode(request.getDoctorCode());
        doctor.setFirstName(request.getFirstName());
        doctor.setMiddleName(request.getMiddleName());
        doctor.setLastName(request.getLastName());
        doctor.setSpecialization(request.getSpecialization());
        doctor.setLicenseNumber(request.getLicenseNumber());
        doctor.setPhone(request.getPhone());
        doctor.setEmail(request.getEmail());
        doctor.setDepartment(department);
        doctor.setStatus(request.getStatus());

        OffsetDateTime now = OffsetDateTime.now();
        doctor.setCreatedAt(now);
        doctor.setUpdatedAt(now);

        Doctor savedDoctor = doctorService.create(doctor);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(toResponse(savedDoctor));
    }

    @GetMapping
    public ResponseEntity<List<DoctorResponse>> getAll() {

        List<DoctorResponse> doctors = doctorService.getAll()
                .stream()
                .map(this::toResponse)
                .toList();

        return ResponseEntity.ok(doctors);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DoctorResponse> getById(
            @PathVariable Long id) {

        Doctor doctor = doctorService.getById(id);

        return ResponseEntity.ok(toResponse(doctor));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DoctorResponse> update(
            @PathVariable Long id,
            @RequestBody DoctorUpdateRequest request) {

        Doctor doctor = doctorService.getById(id);

        Department department =
                departmentService.getById(request.getDepartmentId());

        doctor.setDoctorCode(request.getDoctorCode());
        doctor.setFirstName(request.getFirstName());
        doctor.setMiddleName(request.getMiddleName());
        doctor.setLastName(request.getLastName());
        doctor.setSpecialization(request.getSpecialization());
        doctor.setLicenseNumber(request.getLicenseNumber());
        doctor.setPhone(request.getPhone());
        doctor.setEmail(request.getEmail());
        doctor.setDepartment(department);
        doctor.setStatus(request.getStatus());
        doctor.setUpdatedAt(OffsetDateTime.now());

        Doctor updatedDoctor = doctorService.update(doctor);

        return ResponseEntity.ok(toResponse(updatedDoctor));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Long id) {

        doctorService.getById(id);
        doctorService.delete(id);

        return ResponseEntity.noContent().build();
    }

    private DoctorResponse toResponse(Doctor doctor) {

        Department department = doctor.getDepartment();

        return new DoctorResponse(
                doctor.getId(),
                doctor.getDoctorCode(),
                doctor.getFirstName(),
                doctor.getMiddleName(),
                doctor.getLastName(),
                doctor.getSpecialization(),
                doctor.getLicenseNumber(),
                doctor.getPhone(),
                doctor.getEmail(),
                department.getId(),
                department.getDepartmentCode(),
                department.getName(),
                doctor.getStatus(),
                doctor.getCreatedAt(),
                doctor.getUpdatedAt()
        );
    }
}