package com.cdc.framework.dto;

import java.util.List;

public class CdcReadinessReport {
    private String databaseId;
    private boolean ready;
    private List<String> checks;
    private String summary;

    public CdcReadinessReport() {
    }

    public CdcReadinessReport(String databaseId, boolean ready, List<String> checks, String summary) {
        this.databaseId = databaseId;
        this.ready = ready;
        this.checks = checks;
        this.summary = summary;
    }

    public String getDatabaseId() {
        return databaseId;
    }

    public void setDatabaseId(String databaseId) {
        this.databaseId = databaseId;
    }

    public boolean isReady() {
        return ready;
    }

    public void setReady(boolean ready) {
        this.ready = ready;
    }

    public List<String> getChecks() {
        return checks;
    }

    public void setChecks(List<String> checks) {
        this.checks = checks;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
