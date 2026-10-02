package com.cdc.framework.service;

import com.cdc.framework.entity.CdcPipeLineConfig;
import com.cdc.framework.dto.CreatePipelineRequest;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PipelineService {

    public ResponseEntity<String> create(CreatePipelineRequest request) {
        return ResponseEntity.ok("Pipeline created successfully");
    }

    public List<CdcPipeLineConfig> all() {
        return new ArrayList<>();
    }

    public CdcPipeLineConfig get(String id) {
        return new CdcPipeLineConfig();
    }
}
