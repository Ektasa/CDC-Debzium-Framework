package com.cdc.framework.entity;

import java.time.LocalDateTime;

public class CdcPipeLineConfig extends BaseAuditableEntity {
    private String databaseId;
    private String pipelineName;
    private String connectorName;
    private String topicPrefix;
    private String tableWhitelist;
    private boolean enabled;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public CdcPipeLineConfig() {
    }

    public CdcPipeLineConfig(String id, String databaseId, String pipelineName, String connectorName,
                            String topicPrefix, String tableWhitelist, boolean enabled, String status) {
        setId(id);
        this.databaseId = databaseId;
        this.pipelineName = pipelineName;
        this.connectorName = connectorName;
        this.topicPrefix = topicPrefix;
        this.tableWhitelist = tableWhitelist;
        this.enabled = enabled;
        this.status = status;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public String getDatabaseId() {
        return databaseId;
    }

    public void setDatabaseId(String databaseId) {
        this.databaseId = databaseId;
    }

    public String getPipelineName() {
        return pipelineName;
    }

    public void setPipelineName(String pipelineName) {
        this.pipelineName = pipelineName;
    }

    public String getConnectorName() {
        return connectorName;
    }

    public void setConnectorName(String connectorName) {
        this.connectorName = connectorName;
    }

    public String getTopicPrefix() {
        return topicPrefix;
    }

    public void setTopicPrefix(String topicPrefix) {
        this.topicPrefix = topicPrefix;
    }

    public String getTableWhitelist() {
        return tableWhitelist;
    }

    public void setTableWhitelist(String tableWhitelist) {
        this.tableWhitelist = tableWhitelist;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public String getStatus() {
        return status;
    }

    @Override
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
