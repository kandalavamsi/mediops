package com.mediops.service;

import com.mediops.entity.Prescription;
import com.mediops.exception.ResourceNotFoundException;
import com.mediops.repository.PrescriptionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PrescriptionService {

    private final PrescriptionRepository prescriptionRepository;

    public PrescriptionService(PrescriptionRepository prescriptionRepository) {
        this.prescriptionRepository = prescriptionRepository;
    }

    public Prescription create(Prescription prescription) {
        Prescription createdPrescription =
                prescriptionRepository.save(prescription);

        initializeRelationships(createdPrescription);

        return createdPrescription;
    }

    @Transactional(readOnly = true)
    public List<Prescription> getAll() {
        return prescriptionRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Prescription getById(Long id) {
        return prescriptionRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Prescription not found with id: " + id));
    }

    public Prescription update(Prescription prescription) {
        Prescription updatedPrescription =
                prescriptionRepository.save(prescription);

        initializeRelationships(updatedPrescription);

        return updatedPrescription;
    }

    public void delete(Long id) {
        prescriptionRepository.deleteById(id);
    }

    private void initializeRelationships(Prescription prescription) {
        prescription.getPatient().getPatientCode();
        prescription.getDoctor().getDoctorCode();

        if (prescription.getMedicalRecord() != null) {
            prescription.getMedicalRecord().getRecordCode();
        }
    }
}