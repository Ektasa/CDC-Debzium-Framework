package com.cdc.framework.dto;

import com.cdc.framework.utils.AuditStatus;

import java.time.Instant;

public class AuditLogEntity {
    private String id;
    private String corelationId;
    private String actorUserId;
    private String action;
    private String resourceId;
    private String resourceType;
    private String beforeStateJson;
    private String afterStateJson;
    private AuditStatus status;
    private String failureReason;
    private Instant createdAt = Instant.now();

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getCorelationId() { return corelationId; }
    public void setCorelationId(String corelationId) { this.corelationId = corelationId; }
    public String getActorUserId() { return actorUserId; }
    public void setActorUserId(String actorUserId) { this.actorUserId = actorUserId; }
    public String getAction() { return action; }
    public void setAction(String action) { this.action = action; }
    public String getResourceId() { return resourceId; }
    public void setResourceId(String resourceId) { this.resourceId = resourceId; }
    public String getResourceType() { return resourceType; }
    public void setResourceType(String resourceType) { this.resourceType = resourceType; }
    public String getBeforeStateJson() { return beforeStateJson; }
    public void setBeforeStateJson(String beforeStateJson) { this.beforeStateJson = beforeStateJson; }
    public String getAfterStateJson() { return afterStateJson; }
    public void setAfterStateJson(String afterStateJson) { this.afterStateJson = afterStateJson; }
    public AuditStatus getStatus() { return status; }
    public void setStatus(AuditStatus status) { this.status = status; }
    public String getFailureReason() { return failureReason; }
    public void setFailureReason(String failureReason) { this.failureReason = failureReason; }
    public Instant getCreatedAt() { return createdAt; }
    public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }
}
