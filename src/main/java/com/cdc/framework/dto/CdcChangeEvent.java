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


}
