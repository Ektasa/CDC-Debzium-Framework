package com.cdc.framework.serviceimpl;

import com.cdc.framework.dto.DatabaseRegistrationRequest;
import com.cdc.framework.entity.RegisteredDatabaseEntity;
import com.cdc.framework.repository.RegisteredDatabaseRepository;
import com.cdc.framework.service.DatabaseRegistryService;
import com.cdc.framework.utils.DatabaseVendor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DatabaseRegistryServiceImpl implements DatabaseRegistryService {

    private final RegisteredDatabaseRepository repository;

    public DatabaseRegistryServiceImpl(RegisteredDatabaseRepository repository) {
        this.repository = repository;
    }

    @Override
//    public RegisteredDatabaseEntity register(DatabaseRegistrationRequest req) {
//        RegisteredDatabaseEntity entity = new RegisteredDatabaseEntity();
//        entity.setName(req.getName());
//        entity.setHost(req.getHost());
//        entity.setPort(req.getPort());
//        entity.setDatabaseName(req.getDatabaseName());
//        entity.setUsername(req.getUsername());
//        entity.setEncryptedPassword(req.getPassword());
//        entity.setSslEnabled(req.getSslEnabled());
//        entity.setSslMode(req.getSslMode());
//
//        // 🔹 Convert string to enum
//
//        entity.setDatabaseVendor(DatabaseVendor.valueOf(req.getDatabaseVendor()));
//        return repository.save(entity);
//
    public RegisteredDatabaseEntity register(DatabaseRegistrationRequest req) {
        RegisteredDatabaseEntity entity = new RegisteredDatabaseEntity();
        entity.setName(req.name());
        entity.setHost(req.host());
        entity.setPort(req.port());
        entity.setDatabaseName(req.databaseName());
        entity.setSchemaName(req.schemaName());
        entity.setUsername(req.username());
        entity.setEncryptedPassword(req.password()); // ideally encrypt
        entity.setSslEnabled(req.sslEnabled());
        entity.setSslMode(req.sslMode());
        entity.setDatabaseVendor(req.databaseVendor()); // enum directly
        return repository.save(entity);
    }


    @Override
    public List<RegisteredDatabaseEntity> getAll() {
        return repository.findAll();
    }

//    @Override
//    public RegisteredDatabaseEntity getById(String id) {
//      return repository.findById(id).orElse(null);
//        RegisteredDatabaseEntity entity = repository.getReferenceById(id);
//        System.out.println(entity.getClass());
//        return entity;
//    }
    @Override
    public RegisteredDatabaseEntity getById(String id) {
        return repository.findById(id).orElse(null);
    }


}




