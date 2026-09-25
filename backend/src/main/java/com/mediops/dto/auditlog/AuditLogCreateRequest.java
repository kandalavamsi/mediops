package com.mediops.dto.auditlog;

public class AuditLogCreateRequest {

    private Long userId;
    private String action;
    private String entityType;
    private Long entityId;
    private String description;
    private String ipAddress;

    public AuditLogCreateRequest() {
    }

    public Long getUserId() {
        return userId;
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
}