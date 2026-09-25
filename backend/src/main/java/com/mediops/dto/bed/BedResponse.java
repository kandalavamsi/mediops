package com.mediops.dto.bed;

import java.time.OffsetDateTime;

public class BedResponse {

    private Long id;
    private String bedCode;

    private Long wardId;
    private String wardCode;
    private String wardName;

    private String bedType;
    private String status;
    private String notes;

    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;

    public BedResponse() {
    }

    public BedResponse(
            Long id,
            String bedCode,
            Long wardId,
            String wardCode,
            String wardName,
            String bedType,
            String status,
            String notes,
            OffsetDateTime createdAt,
            OffsetDateTime updatedAt) {

        this.id = id;
        this.bedCode = bedCode;
        this.wardId = wardId;
        this.wardCode = wardCode;
        this.wardName = wardName;
        this.bedType = bedType;
        this.status = status;
        this.notes = notes;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public String getBedCode() {
        return bedCode;
    }

    public Long getWardId() {
        return wardId;
    }

    public String getWardCode() {
        return wardCode;
    }

    public String getWardName() {
        return wardName;
    }

    public String getBedType() {
        return bedType;
    }

    public String getStatus() {
        return status;
    }

    public String getNotes() {
        return notes;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public OffsetDateTime getUpdatedAt() {
        return updatedAt;
    }
}