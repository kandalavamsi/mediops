package com.mediops.service;

import com.mediops.entity.Appointment;
import com.mediops.exception.ResourceNotFoundException;
import com.mediops.repository.AppointmentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;

    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public Appointment create(Appointment appointment) {
        Appointment createdAppointment = appointmentRepository.save(appointment);

        initializeRelationships(createdAppointment);

        return createdAppointment;
    }

    @Transactional(readOnly = true)
    public List<Appointment> getAll() {
        return appointmentRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Appointment getById(Long id) {

        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Appointment not found with id: " + id));

        initializeRelationships(appointment);

        return appointment;
    }

    public Appointment update(Appointment appointment) {

        Appointment updatedAppointment = appointmentRepository.save(appointment);

        initializeRelationships(updatedAppointment);

        return updatedAppointment;
    }

    public void delete(Long id) {
        appointmentRepository.deleteById(id);
    }

    private void initializeRelationships(Appointment appointment) {

        appointment.getPatient().getPatientCode();

        appointment.getDoctor().getDoctorCode();

        appointment.getDepartment().getDepartmentCode();
    }
}