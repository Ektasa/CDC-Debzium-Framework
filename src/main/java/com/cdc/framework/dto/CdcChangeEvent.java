package com.cdc.framework.dto;

import com.cdc.framework.utils.DatabaseVendor;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "cdc_change_event")
public class CdcChangeEvent {
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "database_id")
    private String databaseId;
    @Column(name = "schema_name")
    private String schemaName;
    @Column(name = "table_name")
    private String tableName;
    @Column(name = "operation")
    private String operation;
    @Column(name = "before_data")
    private String before;
    @Column(name = "after_data")
    private String after;
    @Column(name = "event_time")
    private LocalDateTime eventTime;

    public CdcChangeEvent() {
    }

    public CdcChangeEvent(String id, String databaseId, String schemaName, String tableName,
                          String operation, String before, String after, LocalDateTime eventTime) {
        this.id = id;
        this.databaseId = databaseId;
        this.schemaName = schemaName;
        this.tableName = tableName;
        this.operation = operation;
        this.before = before;
        this.after = after;
        this.eventTime = eventTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDatabaseId() {
        return databaseId;
    }

    public void setDatabaseId(String databaseId) {
        this.databaseId = databaseId;
    }

    public String getSchemaName() {
        return schemaName;
    }

    public void setSchemaName(String schemaName) {
        this.schemaName = schemaName;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getBefore() {
        return before;
    }

    public void setBefore(String before) {
        this.before = before;
    }

    public String getAfter() {
        return after;
    }

    public void setAfter(String after) {
        this.after = after;
    }

    public LocalDateTime getEventTime() {
        return eventTime;
    }

    public void setEventTime(LocalDateTime eventTime) {
        this.eventTime = eventTime;
    }

    @Entity
    @Table(name = "registered_database")
    public static class RegisteredDatabaseEntity {
        @Id
        @Column(name = "id")
        private String id;
        @Column(name = "name")
        private String name;
        @Column(name = "host")
        private String host;
        @Column(name = "port")
        private Integer port;
        @Column(name = "database_name")
        private String databaseName;
        @Column(name = "username")
        private String username;
        @Column(name = "password")
        private String password;
        @Column(name = "database_vendor")
        private DatabaseVendor databaseVendor = DatabaseVendor.H2;
        @Column(name = "connection_type")
        private String connectionType;
        @Column(name = "connection_url")
        private String connectionUrl;
        @Column(name = "status")
        private String status;
        @Column(name = "created_at")
        private LocalDateTime createdAt;
        @Column(name = "updated_at")
        private LocalDateTime updatedAt;

        public RegisteredDatabaseEntity() {
        }

        public RegisteredDatabaseEntity(String id, String name, String host, Integer port,
                                       String databaseName, String username, String password,
                                       DatabaseVendor databaseVendor, String connectionType, String connectionUrl, String status) {
            this.id = id;
            this.name = name;
            this.host = host;
            this.port = port;
            this.databaseName = databaseName;
            this.username = username;
            this.password = password;
            this.databaseVendor = databaseVendor;
            this.connectionType = connectionType;
            this.connectionUrl = connectionUrl;
            this.status = status;
            this.createdAt = LocalDateTime.now();
            this.updatedAt = LocalDateTime.now();
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getHost() {
            return host;
        }

        public void setHost(String host) {
            this.host = host;
        }

        public Integer getPort() {
            return port;
        }

        public void setPort(Integer port) {
            this.port = port;
        }

        public String getDatabaseName() {
            return databaseName;
        }

        public void setDatabaseName(String databaseName) {
            this.databaseName = databaseName;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getEncryptedPassword() {
            return password;
        }

        public void setEncryptedPassword(String password) {
            this.password = password;
        }

        public DatabaseVendor getDatabaseVendor() {
            return databaseVendor == null ? DatabaseVendor.H2 : databaseVendor;
        }

        public void setDatabaseVendor(DatabaseVendor databaseVendor) {
            this.databaseVendor = databaseVendor;
        }

        public DatabaseVendor getDbType() {
            return getDatabaseVendor();
        }

        public String getDbName() {
            return databaseName;
        }

        public String getConnectionType() {
            return connectionType;
        }

        public void setConnectionType(String connectionType) {
            this.connectionType = connectionType;
        }

        public String getConnectionUrl() {
            return connectionUrl;
        }

        public void setConnectionUrl(String connectionUrl) {
            this.connectionUrl = connectionUrl;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public LocalDateTime getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
        }

        public LocalDateTime getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(LocalDateTime updatedAt) {
            this.updatedAt = updatedAt;
        }
    }
}
