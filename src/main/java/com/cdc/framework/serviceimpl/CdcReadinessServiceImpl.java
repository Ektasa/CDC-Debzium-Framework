package com.cdc.framework.serviceimpl;


import com.cdc.framework.domain.RegisteredDatabaseEntity;
import com.cdc.framework.dto.CdcReadinessReport;
import com.cdc.framework.utils.CheckStatus;
import com.cdc.framework.utils.JdbcUrlFactory;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;

import static com.cdc.framework.utils.DatabaseVendor.*;

@Service
public class CdcReadinessServiceImpl {

    private final JdbcUrlFactory jdbcUrlFactory;
    private final SimpleSecretService simpleSecretService;

    public CdcReadinessServiceImpl(JdbcUrlFactory jdbcUrlFactory, SimpleSecretService simpleSecretService) {
        this.jdbcUrlFactory = jdbcUrlFactory;
        this.simpleSecretService = simpleSecretService;
    }

    @Override
    public CdcReadinessReport check(RegisteredDatabaseEntity db)
    {
        List<CdcReadinessReport.CheckResult> checks = new ArrayList<>();
        boolean supported= switch (db.getDatabaseVendor()) {
            case MYSQL, POSTGRESQL, ORACLE, SQLSERVER -> true;
            default -> false;
        };
        try(Connection c= DriverManager.getConnection(jdbcUrlFactory.jdbcUrl(db), db.getUsername(), simpleSecretService.decrypt(db.getPassword()))) {
        switch(db.getDatabaseVendor())
        {
            case POSTGRESQL->postgres(c,checks);
            case MYSQL, MARIADB->mysql(c,checks);
            case ORACLE->oracle(c,checks);
            case SQLSERVER->sqlserver(c,checks);
            default->{
                checks.add(new CdcReadinessReport.CheckResult("Database Vendor", false, "Unsupported database vendor: " + db.getDatabaseVendor()));
            }
        }

        } catch (SQLException e) {
            checks.add(new CdcReadinessReport.CheckResult("Connection", false, "Failed to connect to the database: " + e.getMessage()));
        }
        boolean ready =supported && checks.stream().noneMatch(c->c.status()== CheckStatus.FAILED);
        );
        return new CdcReadinessReport(db.getId(), db.getDatabaseVendor.name(), supported, ready,checks)
    }

    private void postgres(Connection c, List<CdcReadinessReport.checkResult> checks) throws SQLException
    {
        checks.add(checkValue(c,"postgres-wal-level", "wal_level", "logical"),
                "set wal_level to logical in postgresql.conf or AlterSystem set wal_level to logical", true);
        checks.add(numberAtLeast(c,"postgres-max-replication-slots", "show max_replication_slots", 1,
                "increase max_replication_slots to at least 1"));

        checks.add(numberAtLeast(c,"postgres-max-wal-senders", "show max_wal_senders", 1,"increase max_wal_senders to at least 1"));

    }

    private void sqlServer(Connection c, List<CdcReadinessReport.checkResult> checks) throws SQLException
    {
        checks.add(new CdcReadinessReport.CheckResult("sqlserver-cdc-enabled",CheckStatus.WARNING, "not required",
                        "CDC enables at database table level",
                        "Run sys.sp_cdc_enable_db  and sys.sp_cdc_enable_table for selected tables; verify SQL server Agent is running",
                        false, true;)

    }
    private void oracle(Connection c, List<CdcReadinessReport.checkResult> checks) throws SQLException
    {
        checks.add(new CdcReadinessReport.CheckResult("oracle-archivelog-mode",CheckStatus.WARNING, "not required",
                "Oracle must be in archivelog mode for CDC to work",
                "Run 'archive log list' to check if archivelog mode is enabled; if not, enable it using 'alter database archivelog'",
                false, true));
    }

   private CdcReadinessReport.CheckResult checkValue(Connection c, String checkName, String name, String sql,
                                                     String excepted, String rec, boolean restart) throws SQLException
   {
       try(Statement stmt=c.createStatement(); ResultSet rs=stmt.executeQuery(sql))
       {
           rs.next();
         String val=re.getMetaData().getColumnCount()>1 ? rs.getString(2) : rs.getString(1);
         boolean ok=expected.equalsIgnoreCase(excepted);
            return new CdcReadinessReport.CheckResult(checkName, ok?CheckStatus.PASSED:CheckStatus.FAILED,
                    expected, ok?"ok": rec, restart, !ok);

       }
   }
   private CdcReadinessReport.CheckResult numberAtLeast(Connection c, String checkName, String sql, int min,
                                                       String rec) throws SQLException {
       try (Statement stmt = c.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
           rs.next();
           String val = rs.getMetaData().getColumnCount() > 1 ? rs.getString(2) : rs.getString(1);
           boolean ok = Integer.parseInt(val) >= min;
           return new CdcReadinessReport.CheckResult(checkName, ok ? CheckStatus.PASSED : CheckStatus.FAILED,
                   val, ">=" + min, ok ? "ok" : rec, false, !ok);
       }


   }

}
