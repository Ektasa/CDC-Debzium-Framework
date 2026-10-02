package com.cdc.framework.utils;

import com.cdc.framework.entity.RegisteredDatabaseEntity;

public class JdbcUrlFactory {

    public String jdbcUrl(RegisteredDatabaseEntity db) {
        String jdbcUrl = null;
        switch (db.getDatabaseVendor()) {
            case MYSQL:
                jdbcUrl = "jdbc:mysql://" + db.getHost() + ":" + db.getPort() + "/" + db.getDatabaseName();
                break;
            case POSTGRESQL:
                jdbcUrl = "jdbc:postgresql://" + db.getHost() + ":" + db.getPort() + "/" + db.getDatabaseName();
                break;
            case ORACLE:
                jdbcUrl = "jdbc:oracle:thin:@" + db.getHost() + ":" + db.getPort() + ":" + db.getDatabaseName();
                break;
            case SQLSERVER:
                jdbcUrl = "jdbc:sqlserver://" + db.getHost() + ":" + db.getPort() + ";databaseName=" + db.getDatabaseName();
                break;
            default:
                throw new IllegalArgumentException("Unsupported database type: " + db.getDatabaseVendor());
        }
        return jdbcUrl;
    }
}
