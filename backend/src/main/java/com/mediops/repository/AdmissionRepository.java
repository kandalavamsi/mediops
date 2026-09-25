package com.mediops.repository;

import com.mediops.entity.Admission;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AdmissionRepository
        extends JpaRepository<Admission, Long> {

    @Override
    @EntityGraph(attributePaths = {
            "patient",
            "doctor",
            "bed",
            "emergency"
    })
    List<Admission> findAll();

    @Override
    @EntityGraph(attributePaths = {
            "patient",
            "doctor",
            "bed",
            "emergency"
    })
    Optional<Admission> findById(Long id);
}