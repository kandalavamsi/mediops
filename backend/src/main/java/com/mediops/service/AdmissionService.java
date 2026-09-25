package com.mediops.service;

import com.mediops.entity.Admission;
import com.mediops.exception.ResourceNotFoundException;
import com.mediops.repository.AdmissionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AdmissionService {

    private final AdmissionRepository admissionRepository;

    public AdmissionService(AdmissionRepository admissionRepository) {
        this.admissionRepository = admissionRepository;
    }

    public Admission create(Admission admission) {
        Admission createdAdmission = admissionRepository.save(admission);

        initializeRelationships(createdAdmission);

        return createdAdmission;
    }

    @Transactional(readOnly = true)
    public List<Admission> getAll() {
        return admissionRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Admission getById(Long id) {
        return admissionRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Admission not found with id: " + id));
    }

    public Admission update(Admission admission) {
        Admission updatedAdmission = admissionRepository.save(admission);

        initializeRelationships(updatedAdmission);

        return updatedAdmission;
    }

    public void delete(Long id) {
        admissionRepository.deleteById(id);
    }

    private void initializeRelationships(Admission admission) {
        admission.getPatient().getPatientCode();
        admission.getDoctor().getDoctorCode();

        if (admission.getBed() != null) {
            admission.getBed().getBedCode();
        }

        if (admission.getEmergency() != null) {
            admission.getEmergency().getEmergencyCode();
        }
    }
}