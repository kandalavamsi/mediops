package com.mediops.controller;

import com.mediops.dto.auditlog.AuditLogCreateRequest;
import com.mediops.dto.auditlog.AuditLogResponse;
import com.mediops.dto.auditlog.AuditLogUpdateRequest;
import com.mediops.entity.AuditLog;
import com.mediops.entity.User;
import com.mediops.service.AuditLogService;
import com.mediops.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/audit-logs")
public class AuditLogController {

    private final AuditLogService auditLogService;
    private final UserService userService;

    public AuditLogController(
            AuditLogService auditLogService,
            UserService userService) {
        this.auditLogService = auditLogService;
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<AuditLogResponse> create(
            @RequestBody AuditLogCreateRequest request) {

        User user = null;

        if (request.getUserId() != null) {
            user = userService.getById(request.getUserId());
        }

        AuditLog auditLog = new AuditLog();

        auditLog.setUser(user);
        auditLog.setAction(request.getAction());
        auditLog.setEntityType(request.getEntityType());
        auditLog.setEntityId(request.getEntityId());
        auditLog.setDescription(request.getDescription());
        auditLog.setIpAddress(request.getIpAddress());
        auditLog.setCreatedAt(OffsetDateTime.now());

        AuditLog createdAuditLog =
                auditLogService.create(auditLog);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(toResponse(createdAuditLog));
    }

    @GetMapping
    public ResponseEntity<List<AuditLogResponse>> getAll() {

        List<AuditLogResponse> responses =
                auditLogService.getAll()
                        .stream()
                        .map(this::toResponse)
                        .toList();

        return ResponseEntity.ok(responses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuditLogResponse> getById(
            @PathVariable Long id) {

        AuditLog auditLog =
                auditLogService.getById(id);

        return ResponseEntity.ok(toResponse(auditLog));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AuditLogResponse> update(
            @PathVariable Long id,
            @RequestBody AuditLogUpdateRequest request) {

        AuditLog auditLog =
                auditLogService.getById(id);

        User user = null;

        if (request.getUserId() != null) {
            user = userService.getById(request.getUserId());
        }

        auditLog.setUser(user);
        auditLog.setAction(request.getAction());
        auditLog.setEntityType(request.getEntityType());
        auditLog.setEntityId(request.getEntityId());
        auditLog.setDescription(request.getDescription());
        auditLog.setIpAddress(request.getIpAddress());

        AuditLog updatedAuditLog =
                auditLogService.update(auditLog);

        return ResponseEntity.ok(toResponse(updatedAuditLog));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Long id) {

        auditLogService.getById(id);
        auditLogService.delete(id);

        return ResponseEntity.noContent().build();
    }

    private AuditLogResponse toResponse(
            AuditLog auditLog) {

        User user = auditLog.getUser();

        Long userId = null;
        String userCode = null;
        String userName = null;

        if (user != null) {
            userId = user.getId();
            userCode = user.getUserCode();
            userName =
                    user.getFirstName() + " " + user.getLastName();
        }

        return new AuditLogResponse(
                auditLog.getId(),
                userId,
                userCode,
                userName,
                auditLog.getAction(),
                auditLog.getEntityType(),
                auditLog.getEntityId(),
                auditLog.getDescription(),
                auditLog.getIpAddress(),
                auditLog.getCreatedAt()
        );
    }
}