package com.cdc.framework.serviceimpl;

public class DatabaseRegistryServiceImpl implements DatabaseRegistryService {
    // Implement the methods defined in the DatabaseRegistryService interface
    private final DatabaseRegistryRepository databaseRegistryRepository;
    private final SimpleService secretService;
    private final AuditService auditService;

    public DatabaseRegistryServiceImpl(DatabaseRegistryRepository databaseRegistryRepository, SimpleService secretService, AuditService auditService) {
        this.databaseRegistryRepository = databaseRegistryRepository;
        this.secretService = secretService;
        this.auditService = auditService;
    }

    @Override
    public void register(DatabaseRegistry databaseRegistry) {
        RegisteredDatabaseEntity db=new RegisteredDatabaseEntity();
        db.setName(databaseRegistry.getName());
        db.setType(databaseRegistry.getType());
        db.setConnectionString(databaseRegistry.getConnectionString());
        db.setUsername(databaseRegistry.getUsername());
        db.setEncryptedPassword(secretService.encrypt(databaseRegistry.getPassword()));
        databaseRegistryRepository.save(db);
        auditService.log("Registered new database: " + db.getName());
    }
}
