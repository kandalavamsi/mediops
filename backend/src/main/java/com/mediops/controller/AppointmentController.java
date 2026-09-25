package com.mediops.controller;

import com.mediops.dto.appointment.AppointmentCreateRequest;
import com.mediops.dto.appointment.AppointmentResponse;
import com.mediops.dto.appointment.AppointmentUpdateRequest;
import com.mediops.entity.Appointment;
import com.mediops.entity.Department;
import com.mediops.entity.Doctor;
import com.mediops.entity.Patient;
import com.mediops.service.AppointmentService;
import com.mediops.service.DepartmentService;
import com.mediops.service.DoctorService;
import com.mediops.service.PatientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;
    private final PatientService patientService;
    private final DoctorService doctorService;
    private final DepartmentService departmentService;

    public AppointmentController(
            AppointmentService appointmentService,
            PatientService patientService,
            DoctorService doctorService,
            DepartmentService departmentService) {

        this.appointmentService = appointmentService;
        this.patientService = patientService;
        this.doctorService = doctorService;
        this.departmentService = departmentService;
    }

    @PostMapping
    public ResponseEntity<AppointmentResponse> create(
            @RequestBody AppointmentCreateRequest request) {

        Patient patient = patientService.getById(request.getPatientId());
        Doctor doctor = doctorService.getById(request.getDoctorId());
        Department department = departmentService.getById(request.getDepartmentId());

        Appointment appointment = new Appointment();

        appointment.setAppointmentCode(request.getAppointmentCode());
        appointment.setPatient(patient);
        appointment.setDoctor(doctor);
        appointment.setDepartment(department);
        appointment.setStartAt(request.getStartAt());
        appointment.setEndAt(request.getEndAt());
        appointment.setReason(request.getReason());
        appointment.setNotes(request.getNotes());
        appointment.setStatus(request.getStatus());

        OffsetDateTime now = OffsetDateTime.now();
        appointment.setCreatedAt(now);
        appointment.setUpdatedAt(now);

        Appointment createdAppointment = appointmentService.create(appointment);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(toResponse(createdAppointment));
    }

    @GetMapping
    public ResponseEntity<List<AppointmentResponse>> getAll() {

        List<AppointmentResponse> responses = appointmentService.getAll()
                .stream()
                .map(this::toResponse)
                .toList();

        return ResponseEntity.ok(responses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppointmentResponse> getById(
            @PathVariable Long id) {

        Appointment appointment = appointmentService.getById(id);

        return ResponseEntity.ok(toResponse(appointment));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AppointmentResponse> update(
            @PathVariable Long id,
            @RequestBody AppointmentUpdateRequest request) {

        Appointment appointment = appointmentService.getById(id);

        Patient patient = patientService.getById(request.getPatientId());
        Doctor doctor = doctorService.getById(request.getDoctorId());
        Department department = departmentService.getById(request.getDepartmentId());

        appointment.setAppointmentCode(request.getAppointmentCode());
        appointment.setPatient(patient);
        appointment.setDoctor(doctor);
        appointment.setDepartment(department);
        appointment.setStartAt(request.getStartAt());
        appointment.setEndAt(request.getEndAt());
        appointment.setReason(request.getReason());
        appointment.setNotes(request.getNotes());
        appointment.setStatus(request.getStatus());
        appointment.setUpdatedAt(OffsetDateTime.now());

        Appointment updatedAppointment = appointmentService.update(appointment);

        return ResponseEntity.ok(toResponse(updatedAppointment));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Long id) {

        appointmentService.getById(id);
        appointmentService.delete(id);

        return ResponseEntity.noContent().build();
    }

    private AppointmentResponse toResponse(Appointment appointment) {

        Patient patient = appointment.getPatient();
        Doctor doctor = appointment.getDoctor();
        Department department = appointment.getDepartment();

        String patientName = patient.getFirstName()
                + " "
                + patient.getLastName();

        String doctorName = doctor.getFirstName()
                + " "
                + doctor.getLastName();

        return new AppointmentResponse(
                appointment.getId(),
                appointment.getAppointmentCode(),

                patient.getId(),
                patient.getPatientCode(),
                patientName,

                doctor.getId(),
                doctor.getDoctorCode(),
                doctorName,

                department.getId(),
                department.getDepartmentCode(),
                department.getName(),

                appointment.getStartAt(),
                appointment.getEndAt(),
                appointment.getReason(),
                appointment.getNotes(),
                appointment.getStatus(),

                appointment.getCreatedAt(),
                appointment.getUpdatedAt()
        );
    }
}