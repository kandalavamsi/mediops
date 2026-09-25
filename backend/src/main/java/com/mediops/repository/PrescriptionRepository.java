package com.mediops.repository;

import com.mediops.entity.Prescription;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PrescriptionRepository
        extends JpaRepository<Prescription, Long> {

    @Override
    @EntityGraph(attributePaths = {"patient", "doctor", "medicalRecord"})
    List<Prescription> findAll();

    @Override
    @EntityGraph(attributePaths = {"patient", "doctor", "medicalRecord"})
    Optional<Prescription> findById(Long id);
}