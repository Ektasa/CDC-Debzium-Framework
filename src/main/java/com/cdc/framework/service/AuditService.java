package com.cdc.framework.service;

public interface AuditService {
    void success(String actor, String action, String resourceType, String resourlceId, String afterJson);

    void failed(String actor, String action, String resourceType, String resourceId, Exception ex);

}
