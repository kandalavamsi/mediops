package com.mediops.dto.auditlog;

import java.time.OffsetDateTime;

public class AuditLogResponse {

    private Long id;

    private Long userId;
    private String userCode;
    private String userName;

    private String action;
    private String entityType;
    private Long entityId;
    private String description;
    private String ipAddress;
    private OffsetDateTime createdAt;

    public AuditLogResponse(
            Long id,
            Long userId,
            String userCode,
            String userName,
            String action,
            String entityType,
            Long entityId,
            String description,
            String ipAddress,
            OffsetDateTime createdAt) {

        this.id = id;
        this.userId = userId;
        this.userCode = userCode;
        this.userName = userName;
        this.action = action;
        this.entityType = entityType;
        this.entityId = entityId;
        this.description = description;
        this.ipAddress = ipAddress;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public String getUserCode() {
        return userCode;
    }

    public String getUserName() {
        return userName;
    }

    public String getAction() {
        return action;
    }

    public String getEntityType() {
        return entityType;
    }

    public Long getEntityId() {
        return entityId;
    }

    public String getDescription() {
        return description;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }
}