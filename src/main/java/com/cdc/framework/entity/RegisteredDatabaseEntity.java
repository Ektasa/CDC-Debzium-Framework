package com.cdc.framework.entity;

import com.cdc.framework.dto.BaseAuditable;
import com.cdc.framework.utils.DatabaseVendor;
import jakarta.persistence.*;

@Entity
@Table(name="registered_database")
public class RegisteredDatabaseEntity extends BaseAuditable {
        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        private String id;
        @Column(nullable = false, unique = true)
        private String name;
        @Column(nullable = false)
        private String host;
        @Enumerated(EnumType.STRING)
        @Column(nullable = false)
        private DatabaseVendor databaseVendor;


        @Column(nullable = false)
        private int port;
        @Column(nullable = false)
        private String databaseName;
        private String schemaName;
        @Column(nullable = false)
        private String username;
        @Column(length = 4000)
        private String encryptedPassword;
        private boolean sslEnabled;
        private String sslMode;
        private String status;




    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getHost() { return host; }
    public void setHost(String host) { this.host = host; }
    public DatabaseVendor getDatabaseVendor() { return databaseVendor; }
    public void setDatabaseVendor(DatabaseVendor databaseVendor) { this.databaseVendor = databaseVendor; }
    public int getPort() { return port; }
    public void setPort(int port) { this.port = port; }
    public String getDatabaseName() { return databaseName; }
    public void setDatabaseName(String databaseName) { this.databaseName = databaseName; }
    public String getSchemaName() { return schemaName; }
    public void setSchemaName(String schemaName) { this.schemaName = schemaName; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getEncryptedPassword() { return encryptedPassword; }
    public void setEncryptedPassword(String encryptedPassword) { this.encryptedPassword = encryptedPassword; }
    public boolean isSslEnabled() { return sslEnabled; }
    public void setSslEnabled(boolean sslEnabled) { this.sslEnabled = sslEnabled; }
    public String getSslMode() { return sslMode; }
    public void setSslMode(String sslMode) { this.sslMode = sslMode; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
