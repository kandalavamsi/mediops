package com.mediops.service;

import com.mediops.entity.PatientVitals;
import com.mediops.exception.ResourceNotFoundException;
import com.mediops.repository.PatientVitalsRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PatientVitalsService {

    private final PatientVitalsRepository patientVitalsRepository;

    public PatientVitalsService(PatientVitalsRepository patientVitalsRepository) {
        this.patientVitalsRepository = patientVitalsRepository;
    }

    public PatientVitals create(PatientVitals patientVitals) {
        PatientVitals createdPatientVitals =
                patientVitalsRepository.save(patientVitals);

        initializeRelationships(createdPatientVitals);

        return createdPatientVitals;
    }

    @Transactional(readOnly = true)
    public List<PatientVitals> getAll() {
        return patientVitalsRepository.findAll();
    }

    @Transactional(readOnly = true)
    public PatientVitals getById(Long id) {
        return patientVitalsRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Patient vitals not found with id: " + id));
    }

    public PatientVitals update(PatientVitals patientVitals) {
        PatientVitals updatedPatientVitals =
                patientVitalsRepository.save(patientVitals);

        initializeRelationships(updatedPatientVitals);

        return updatedPatientVitals;
    }

    public void delete(Long id) {
        patientVitalsRepository.deleteById(id);
    }

    private void initializeRelationships(PatientVitals patientVitals) {
        patientVitals.getPatient().getPatientCode();
    }
}