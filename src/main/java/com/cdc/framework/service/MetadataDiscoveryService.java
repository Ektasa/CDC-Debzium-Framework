package com.cdc.framework.service;

import com.cdc.framework.model.DiscoveredTable;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MetadataDiscoveryService {

    public List<DiscoveredTable> discoverTables(String id) {
        return new ArrayList<>();
    }
}
