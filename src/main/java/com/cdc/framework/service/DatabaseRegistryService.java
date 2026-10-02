package com.cdc.framework.service;

import com.cdc.framework.dto.DatabaseRegistrationRequest;
import java.util.List;
import com.cdc.framework.entity.RegisteredDatabaseEntity;

public interface DatabaseRegistryService {
    RegisteredDatabaseEntity register(DatabaseRegistrationRequest req);
    List<RegisteredDatabaseEntity> getAll();
    RegisteredDatabaseEntity getById(String id);
}
