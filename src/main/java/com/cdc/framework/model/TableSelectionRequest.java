package com.cdc.framework.model;

import java.util.List;

public class TableSelectionRequest {
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
