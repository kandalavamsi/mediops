package com.mediops.repository;

import com.mediops.entity.MedicalRecord;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MedicalRecordRepository
        extends JpaRepository<MedicalRecord, Long> {

    @Override
    @EntityGraph(attributePaths = {
            "patient",
            "doctor",
            "appointment"
    })
    List<MedicalRecord> findAll();

    @Override
    @EntityGraph(attributePaths = {
            "patient",
            "doctor",
            "appointment"
    })
    Optional<MedicalRecord> findById(Long id);
}