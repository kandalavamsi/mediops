package com.mediops.repository;

import com.mediops.entity.PatientVitals;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PatientVitalsRepository
        extends JpaRepository<PatientVitals, Long> {

    @Override
    @EntityGraph(attributePaths = {"patient"})
    List<PatientVitals> findAll();

    @Override
    @EntityGraph(attributePaths = {"patient"})
    Optional<PatientVitals> findById(Long id);
}