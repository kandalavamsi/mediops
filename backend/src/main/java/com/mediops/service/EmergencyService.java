package com.mediops.service;

import com.mediops.entity.Emergency;
import com.mediops.exception.ResourceNotFoundException;
import com.mediops.repository.EmergencyRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmergencyService {

    private final EmergencyRepository emergencyRepository;

    public EmergencyService(EmergencyRepository emergencyRepository) {
        this.emergencyRepository = emergencyRepository;
    }

    public Emergency create(Emergency emergency) {
        Emergency createdEmergency = emergencyRepository.save(emergency);

        initializeRelationships(createdEmergency);

        return createdEmergency;
    }

    @Transactional(readOnly = true)
    public List<Emergency> getAll() {
        return emergencyRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Emergency getById(Long id) {
        return emergencyRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Emergency not found with id: " + id));
    }

    public Emergency update(Emergency emergency) {
        Emergency updatedEmergency = emergencyRepository.save(emergency);

        initializeRelationships(updatedEmergency);

        return updatedEmergency;
    }

    public void delete(Long id) {
        emergencyRepository.deleteById(id);
    }

    private void initializeRelationships(Emergency emergency) {
        emergency.getPatient().getPatientCode();

        if (emergency.getDoctor() != null) {
            emergency.getDoctor().getDoctorCode();
        }

        emergency.getDepartment().getDepartmentCode();
    }
}