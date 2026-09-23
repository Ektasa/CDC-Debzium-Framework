package com.cdc.framework.dto;

import com.cdc.framework.utils.AuditStatus;
import lombok.Data;

import java.time.Instant;

@Data
public class AuditLogEntity {
    private String id;
    private String corelationId;
    private String actorUserId;
    private String action;
    private String resourceId;
    private String resourceType;
    private String beforeStateJson;private String afterStateJson;
    private AuditStatus status;
    private String failureReason;
    private Instant createdAt=Instant.now();




}
