package com.cdc.framework.service;

import com.cdc.framework.domain.RegisteredDatabaseEntity;
import com.cdc.framework.model.DatabaseRegistrationRequest;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class DatabaseService {

    public RegisteredDatabaseEntity register(DatabaseRegistrationRequest req) {
        RegisteredDatabaseEntity entity = new RegisteredDatabaseEntity();
        entity.setName(req.getName());
        entity.setHost(req.getHost());
        entity.setPort(req.getPort());
        entity.setDatabaseName(req.getDatabaseName());
        entity.setUsername(req.getUsername());
        entity.setPassword(req.getPassword());
        entity.setConnectionType(req.getConnectionType());
        entity.setConnectionUrl(req.getConnectionUrl());
        entity.setStatus("REGISTERED");
        return entity;
    }

    public List<RegisteredDatabaseEntity> getAll() {
        return new ArrayList<>();
    }

    public RegisteredDatabaseEntity getById(String id) {
        return new RegisteredDatabaseEntity();
    }
}
