package com.cdc.framework.model;

public class DatabaseRegistrationRequest {
    private String name;
    private String host;
    private Integer port;
    private String databaseName;
    private String username;
    private String password;
    private String connectionType;
    private String connectionUrl;

    public DatabaseRegistrationRequest() {
    }

    public DatabaseRegistrationRequest(String name, String host, Integer port, String databaseName,
                                      String username, String password, String connectionType, String connectionUrl) {
        this.name = name;
        this.host = host;
        this.port = port;
        this.databaseName = databaseName;
        this.username = username;
        this.password = password;
        this.connectionType = connectionType;
        this.connectionUrl = connectionUrl;
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
}
