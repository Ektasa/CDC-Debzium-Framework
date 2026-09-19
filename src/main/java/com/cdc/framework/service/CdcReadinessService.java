package com.cdc.framework.service;

import org.springframework.stereotype.Service;

@Service
public class CdcReadinessService {

    public boolean isReady(String id) {
        return true;
    }
}
