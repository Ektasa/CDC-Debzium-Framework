package com.cdc.framework.service;

import com.cdc.framework.entity.CdcPipeLineConfig;
import com.cdc.framework.model.CreatePipelineRequest;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PipelineService {

    public ResponseEntity<String> create(CreatePipelineRequest request) {
        return ResponseEntity.ok("Pipeline created successfully");
    }

    public List<CdcPipeLineConfig> alll() {
        return new ArrayList<>();
    }

    public CdcPipeLineConfig get(String id) {
        return new CdcPipeLineConfig();
    }
}
