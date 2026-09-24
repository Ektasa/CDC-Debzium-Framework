package com.cdc.framework.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "audit_log")
public class AuditLogEntity extends BaseAuditableEntity {
    @Column(name = "audit_id")
    private String auditId;
    @Column(name = "action")
    private String action;
    @Column(name = "resource_type")
    private String resourceType;
    @Column(name = "resource_id")
    private String resourceId;
    @Column(name = "details")
    private String details;
    @Column(name = "actor")
    private String actor;
    @Column(name = "correlation_id")
    private String correlationId;
    @Column(name = "event_time")
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
