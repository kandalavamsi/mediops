package com.mediops.repository;

import com.mediops.entity.Appointment;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AppointmentRepository
        extends JpaRepository<Appointment, Long> {

    @Override
    @EntityGraph(attributePaths = {
            "patient",
            "doctor",
            "department"
    })
    List<Appointment> findAll();

    @Override
    @EntityGraph(attributePaths = {
            "patient",
            "doctor",
            "department"
    })
    Optional<Appointment> findById(Long id);
}