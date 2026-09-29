package com.cdc.framework.serviceimpl;

import com.cdc.framework.service.AuditService;
import org.springframework.stereotype.Service;

@Service
public class AuditServiceImpl implements AuditService {

    @Override
    public void success(
            String actor,
            String action,
            String resourceType,
            String resourlceId,
            String afterJson) {

    }

    @Override
    public void failed(
            String actor,
            String action,
            String resourceType,
            String resourceId,
            Exception ex) {

    }
}