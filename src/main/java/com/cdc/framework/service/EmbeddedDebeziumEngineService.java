package com.cdc.framework.service;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class EmbeddedDebeziumEngineService {

    public void start(String id) {
    }

    public void stop(String id) {
    }

    public Map<String, String> status(String id) {
        Map<String, String> status = new HashMap<>();
        status.put("id", id);
        status.put("status", "STOPPED");
        return status;
    }
}
