package com.mediops.service;

import com.mediops.entity.AuditLog;
import com.mediops.exception.ResourceNotFoundException;
import com.mediops.repository.AuditLogRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AuditLogService {

    private final AuditLogRepository auditLogRepository;

    public AuditLogService(AuditLogRepository auditLogRepository) {
        this.auditLogRepository = auditLogRepository;
    }

    public AuditLog create(AuditLog auditLog) {
        AuditLog createdAuditLog =
                auditLogRepository.save(auditLog);

        initializeRelationships(createdAuditLog);

        return createdAuditLog;
    }

    @Transactional(readOnly = true)
    public List<AuditLog> getAll() {
        return auditLogRepository.findAll();
    }

    @Transactional(readOnly = true)
    public AuditLog getById(Long id) {
        return auditLogRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Audit log not found with id: " + id));
    }

    public AuditLog update(AuditLog auditLog) {
        AuditLog updatedAuditLog =
                auditLogRepository.save(auditLog);

        initializeRelationships(updatedAuditLog);

        return updatedAuditLog;
    }

    public void delete(Long id) {
        auditLogRepository.deleteById(id);
    }

    private void initializeRelationships(AuditLog auditLog) {
        if (auditLog.getUser() != null) {
            auditLog.getUser().getUserCode();
        }
    }
}