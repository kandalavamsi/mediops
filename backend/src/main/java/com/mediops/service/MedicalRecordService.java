package com.mediops.service;

import com.mediops.entity.MedicalRecord;
import com.mediops.exception.ResourceNotFoundException;
import com.mediops.repository.MedicalRecordRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MedicalRecordService {

    private final MedicalRecordRepository medicalRecordRepository;

    public MedicalRecordService(MedicalRecordRepository medicalRecordRepository) {
        this.medicalRecordRepository = medicalRecordRepository;
    }

    public MedicalRecord create(MedicalRecord medicalRecord) {
        MedicalRecord createdMedicalRecord =
                medicalRecordRepository.save(medicalRecord);

        initializeRelationships(createdMedicalRecord);

        return createdMedicalRecord;
    }

    @Transactional(readOnly = true)
    public List<MedicalRecord> getAll() {
        return medicalRecordRepository.findAll();
    }

    @Transactional(readOnly = true)
    public MedicalRecord getById(Long id) {
        return medicalRecordRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Medical record not found with id: " + id));
    }

    public MedicalRecord update(MedicalRecord medicalRecord) {
        MedicalRecord updatedMedicalRecord =
                medicalRecordRepository.save(medicalRecord);

        initializeRelationships(updatedMedicalRecord);

        return updatedMedicalRecord;
    }

    public void delete(Long id) {
        medicalRecordRepository.deleteById(id);
    }

    private void initializeRelationships(MedicalRecord medicalRecord) {

        medicalRecord.getPatient().getPatientCode();
        medicalRecord.getDoctor().getDoctorCode();

        if (medicalRecord.getAppointment() != null) {
            medicalRecord.getAppointment().getAppointmentCode();
        }
    }
}