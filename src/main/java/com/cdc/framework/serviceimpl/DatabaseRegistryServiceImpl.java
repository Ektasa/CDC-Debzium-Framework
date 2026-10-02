package com.cdc.framework.serviceimpl;

import com.cdc.framework.dto.DatabaseRegistrationRequest;
import com.cdc.framework.entity.RegisteredDatabaseEntity;
import com.cdc.framework.service.DatabaseRegistryService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DatabaseRegistryServiceImpl implements DatabaseRegistryService {

    @Override
    public RegisteredDatabaseEntity register(DatabaseRegistrationRequest req) {
        return null;
    }

    @Override
    public List<RegisteredDatabaseEntity> getAll() {
        return List.of();
    }

    @Override
    public RegisteredDatabaseEntity getById(String id) {
        return null;
    }
}
