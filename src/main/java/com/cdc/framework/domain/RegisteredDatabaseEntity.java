package com.cdc.framework.domain;

import com.cdc.framework.utils.DatabaseVendor;

import java.time.LocalDateTime;

public class RegisteredDatabaseEntity {
    private String id;
    private String name;
    private String host;
    private Integer port;
    private String databaseName;
    private String username;
    private String password;
    private String connectionType;
    private String connectionUrl;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public RegisteredDatabaseEntity() {
    }

    public RegisteredDatabaseEntity(String id, String name, String host, Integer port,
                                   String databaseName, String username, String password,
                                   String connectionType, String connectionUrl, String status) {
        this.id = id;
        this.name = name;
        this.host = host;
        this.port = port;
        this.databaseName = databaseName;
        this.username = username;
        this.password = password;
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

    public DatabaseVendor getDbType() {
    }
}
