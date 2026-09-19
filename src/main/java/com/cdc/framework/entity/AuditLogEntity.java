package com.cdc.framework.entity;

import java.time.LocalDateTime;

public class AuditLogEntity extends BaseAuditableEntity {
    private String auditId;
    private String action;
    private String resourceType;
    private String resourceId;
    private String details;
    private String actor;
    private String correlationId;
    private LocalDateTime eventTime;

    public AuditLogEntity() {
    }

    public AuditLogEntity(String auditId, String action, String resourceType, String resourceId,
                          String details, String actor, String correlationId, LocalDateTime eventTime) {
        this.auditId = auditId;
        this.action = action;
        this.resourceType = resourceType;
        this.resourceId = resourceId;
        this.details = details;
        this.actor = actor;
        this.correlationId = correlationId;
        this.eventTime = eventTime;
    }

    public String getAuditId() {
        return auditId;
    }

    public void setAuditId(String auditId) {
        this.auditId = auditId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getCorrelationId() {
        return correlationId;
    }

    public void setCorrelationId(String correlationId) {
        this.correlationId = correlationId;
    }

    public LocalDateTime getEventTime() {
        return eventTime;
    }

    public void setEventTime(LocalDateTime eventTime) {
        this.eventTime = eventTime;
    }
}
