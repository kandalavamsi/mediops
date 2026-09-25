package com.mediops.repository;

import com.mediops.entity.AuditLog;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AuditLogRepository
        extends JpaRepository<AuditLog, Long> {

    @Override
    @EntityGraph(attributePaths = {"user"})
    List<AuditLog> findAll();

    @Override
    @EntityGraph(attributePaths = {"user"})
    Optional<AuditLog> findById(Long id);
}