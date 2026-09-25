package com.mediops.service;

import com.mediops.entity.Doctor;
import com.mediops.repository.DoctorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.mediops.exception.ResourceNotFoundException;

import java.util.List;

@Service
@Transactional
public class DoctorService {

    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public Doctor create(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @Transactional(readOnly = true)
    public List<Doctor> getAll() {
        return doctorRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Doctor getById(Long id) {
        return doctorRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Doctor not found with id: " + id));
    }

    @Transactional
    public Doctor update(Doctor doctor) {

        Doctor updatedDoctor = doctorRepository.save(doctor);

        updatedDoctor.getDepartment().getDepartmentCode();
        updatedDoctor.getDepartment().getName();

        return updatedDoctor;
    }

    public void delete(Long id) {
        doctorRepository.deleteById(id);
    }
}