package com.cdc.framework.dto;

import com.cdc.framework.utils.CheckStatus;

import java.util.List;

public class CdcReadinessReport {
    private String databaseId;
    private String databaseVendor;
    private boolean supported;
    private boolean ready;
    private List<CheckResult> checks;

    public CdcReadinessReport() {
    }

    public CdcReadinessReport(String databaseId, String databaseVendor, boolean supported, boolean ready,
                              List<CheckResult> checks) {
        this.databaseId = databaseId;
        this.databaseVendor = databaseVendor;
        this.supported = supported;
        this.ready = ready;
        this.checks = checks;
    }

    public String getDatabaseId() {
        return databaseId;
    }

    public void setDatabaseId(String databaseId) {
        this.databaseId = databaseId;
    }

    public String getDatabaseVendor() {
        return databaseVendor;
    }

    public void setDatabaseVendor(String databaseVendor) {
        this.databaseVendor = databaseVendor;
    }

    public boolean isSupported() {
        return supported;
    }

    public void setSupported(boolean supported) {
        this.supported = supported;
    }

    public boolean isReady() {
        return ready;
    }

    public void setReady(boolean ready) {
        this.ready = ready;
    }

    public List<CheckResult> getChecks() {
        return checks;
    }

    public void setChecks(List<CheckResult> checks) {
        this.checks = checks;
    }

    public static class CheckResult {
        private final String name;
        private final CheckStatus status;
        private final String expected;
        private final String actual;
        private final String remediation;
        private final boolean required;
        private final boolean warning;

        public CheckResult(String name, CheckStatus status, String expected, String actual, String remediation,
                           boolean required, boolean warning) {
            this.name = name;
            this.status = status;
            this.expected = expected;
            this.actual = actual;
            this.remediation = remediation;
            this.required = required;
            this.warning = warning;
        }

        public String getName() {
            return name;
        }

        public CheckStatus getStatus() {
            return status;
        }

        public String getExpected() {
            return expected;
        }

        public String getActual() {
            return actual;
        }

        public String getRemediation() {
            return remediation;
        }

        public boolean isRequired() {
            return required;
        }

        public boolean isWarning() {
            return warning;
        }
    }
}
