package com.cdc.framework.entity;

public class TrackedTableEntity extends BaseAuditableEntity {
    private String pipelineId;
    private String databaseId;
    private String schemaName;
    private String tableName;
    private boolean selected;

    public TrackedTableEntity() {
    }

    public TrackedTableEntity(String id, String pipelineId, String databaseId,
                             String schemaName, String tableName, boolean selected) {
        setId(id);
        this.pipelineId = pipelineId;
        this.databaseId = databaseId;
        this.schemaName = schemaName;
        this.tableName = tableName;
        this.selected = selected;
    }

    public String getPipelineId() {
        return pipelineId;
    }

    public void setPipelineId(String pipelineId) {
        this.pipelineId = pipelineId;
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

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
