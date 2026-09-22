package com.cdc.framework.model;

public class DiscoveredTable {
    private String schemaName;
    private String tableName;
    private String type;

    public DiscoveredTable() {
    }

    public DiscoveredTable(String schemaName, String tableName, String type) {
        this.schemaName = schemaName;
        this.tableName = tableName;
        this.type = type;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
