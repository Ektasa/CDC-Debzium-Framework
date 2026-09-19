package com.cdc.framework.serviceimpl;

import com.cdc.framework.domain.RegisteredDatabaseEntity;
import com.cdc.framework.service.ConnectionTestService;
import com.cdc.framework.utils.JdbcUrlFactory;

import java.sql.DriverManager;
import java.util.Map;

public class ConnectionTestServiceImpl implements ConnectionTestService {

    private final JdbcUrlFactory jdbcUrlFactory;
    private final SimpleSecretService simpleSecretService;

    public ConnectionTestServiceImpl(JdbcUrlFactory jdbcUrlFactory, SimpleSecretService simpleSecretService) {
        this.jdbcUrlFactory = jdbcUrlFactory;
        this.simpleSecretService = simpleSecretService;
    }
    @Override
    public Map<String, Object> test(RegisteredDatabaseEntity db)
    {
        try(var c= DriverManager.getConnection(jdbcUrlFactory.dbcUrl(db), db.getUsername(db),
                simpleSecretService.reveal(db.getEncryptedPassword())))
        {
            return Map.of("status",true, "databaseProduct", c.getMetaData().getDatabaseProductName(),
                    "databaseVersion", c.getMetaData().getDatabaseProductVersion());
        }
        catch (Exception e)
        {
            return Map.of("status", false, "error", e.getMessage());
        }
    }

}
