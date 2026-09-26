package com.cdc.framework.dto;

import java.util.List;

public class CreatePipelineRequest {
    private String databaseId;
    private String pipelineName;
    private String connectorName;
    private String topicPrefix;
    private String tableWhitelist;

    public CreatePipelineRequest() {
    }

    public CreatePipelineRequest(String databaseId, String pipelineName, String connectorName,
                                String topicPrefix, String tableWhitelist) {
        this.databaseId = databaseId;
        this.pipelineName = pipelineName;
        this.connectorName = connectorName;
        this.topicPrefix = topicPrefix;
        this.tableWhitelist = tableWhitelist;
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

    public static class TableSelectionRequest {
        private List<String> tableNames;

        public TableSelectionRequest() {
        }

        public TableSelectionRequest(List<String> tableNames) {
            this.tableNames = tableNames;
        }

        public List<String> getTableNames() {
            return tableNames;
        }

        public void setTableNames(List<String> tableNames) {
            this.tableNames = tableNames;
        }
    }
}
