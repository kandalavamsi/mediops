package com.mediops.repository;

import com.mediops.entity.Bed;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BedRepository extends JpaRepository<Bed, Long> {

    @Override
    @EntityGraph(attributePaths = "ward")
    List<Bed> findAll();

    @Override
    @EntityGraph(attributePaths = "ward")
    Optional<Bed> findById(Long id);
}