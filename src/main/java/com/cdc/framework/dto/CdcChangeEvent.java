package com.cdc.framework.dto;

import java.time.LocalDateTime;

public class CdcChangeEvent {
    private String databaseId;
    private String schemaName;
    private String tableName;
    private String operation;
    private String before;
    private String after;
    private LocalDateTime eventTime;

    public CdcChangeEvent() {
    }

    public CdcChangeEvent(String databaseId, String schemaName, String tableName,
                          String operation, String before, String after, LocalDateTime eventTime) {
        this.databaseId = databaseId;
        this.schemaName = schemaName;
        this.tableName = tableName;
        this.operation = operation;
        this.before = before;
        this.after = after;
        this.eventTime = eventTime;
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
}
