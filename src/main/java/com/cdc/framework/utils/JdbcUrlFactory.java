package com.cdc.framework.utils;

import com.cdc.framework.domain.RegisteredDatabaseEntity;

import static com.cdc.framework.utils.DatabaseVendor.*;

public class JdbcUrlFactory {

    public String jdbcUrl(RegisteredDatabaseEntity db) {
        String jdbcUrl = null;
        switch (db.getDbType()) {
            case MYSQL:
                jdbcUrl = "jdbc:mysql://" + db.getHost() + ":" + db.getPort() + "/" + db.getDbName();
                break;
            case POSTGRESQL:
                jdbcUrl = "jdbc:postgresql://" + db.getHost() + ":" + db.getPort() + "/" + db.getDbName();
                break;
            case ORACLE:
                jdbcUrl = "jdbc:oracle:thin:@" + db.getHost() + ":" + db.getPort() + ":" + db.getDbName();
                break;
            case SQLSERVER:
                jdbcUrl = "jdbc:sqlserver://" + db.getHost() + ":" + db.getPort() + ";databaseName=" + db.getDbName();
                break;
            default:
                throw new IllegalArgumentException("Unsupported database type: " + db.getDbType());
        }
        return jdbcUrl;
    }
}
