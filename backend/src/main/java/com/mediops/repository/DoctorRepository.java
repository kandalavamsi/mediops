package com.mediops.repository;

import com.mediops.entity.Doctor;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    @Override
    @EntityGraph(attributePaths = "department")
    List<Doctor> findAll();

    @Override
    @EntityGraph(attributePaths = "department")
    Optional<Doctor> findById(Long id);
}