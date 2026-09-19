package com.cdc.framework.service;

import com.cdc.framework.entity.TrackedTableEntity;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class TableSelectionService {

    public List<TrackedTableEntity> replaceSelection(String pipelineId, List<String> tableNames) {
        return new ArrayList<>();
    }

    public List<TrackedTableEntity> getSelectedTables(String pipelineId) {
        return new ArrayList<>();
    }
}
