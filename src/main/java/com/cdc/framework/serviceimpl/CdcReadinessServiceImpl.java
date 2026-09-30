package com.cdc.framework.serviceimpl;

import com.cdc.framework.dto.CdcChangeEvent;
import com.cdc.framework.dto.CdcReadinessReport;
import com.cdc.framework.entity.RegisteredDatabaseEntity;
import com.cdc.framework.utils.CheckStatus;
import com.cdc.framework.utils.DatabaseVendor;

import java.util.ArrayList;
import java.util.List;

public class CdcReadinessServiceImpl {

    public CdcReadinessReport check(RegisteredDatabaseEntity db) {
        List<CdcReadinessReport.CheckResult> checks = new ArrayList<>();
        DatabaseVendor vendor = db != null ? db.getDatabaseVendor() : null;
        boolean supported = vendor == DatabaseVendor.MYSQL
                || vendor == DatabaseVendor.POSTGRESQL
                || vendor == DatabaseVendor.MARIADB
                || vendor == DatabaseVendor.ORACLE
                || vendor == DatabaseVendor.SQLSERVER;

        if (!supported) {
            checks.add(new CdcReadinessReport.CheckResult(
                    "Database Vendor",
                    CheckStatus.FAILED,
                    "Supported CDC vendor",
                    vendor == null ? "unknown" : vendor.name(),
                    "Use a supported database vendor for CDC.",
                    true,
                    false
            ));
        }

        boolean ready = supported && checks.stream().noneMatch(c -> c.getStatus() == CheckStatus.FAILED);
        return new CdcReadinessReport(
                db != null ? db.getId() : null,
                vendor == null ? null : vendor.name(),
                supported,
                ready,
                checks
        );
    }
}
