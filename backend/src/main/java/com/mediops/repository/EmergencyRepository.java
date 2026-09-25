package com.mediops.repository;

import com.mediops.entity.Emergency;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmergencyRepository
        extends JpaRepository<Emergency, Long> {

    @Override
    @EntityGraph(attributePaths = {
            "patient",
            "doctor",
            "department"
    })
    List<Emergency> findAll();

    @Override
    @EntityGraph(attributePaths = {
            "patient",
            "doctor",
            "department"
    })
    Optional<Emergency> findById(Long id);
}