
package com.cdc.framework.dto;
import com.cdc.framework.dto.BaseAuditable;
import com.cdc.framework.utils.DatabaseVendor;
import jakarta.persistence.*;
import lombok.Data;
import org.apache.kafka.common.network.Mode;

@Data
public class RegisteredDatabase extends BaseAuditable {

@Id
@GeneratedValue(strategy= GenerationType.UUID)
    private String id;

    @Column(nullable = false, unique = true)
    private String description;

    @Column(nullable = false, unique = true)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DatabaseVendor DatabaseVendor;

    @Column(nullable = false)
    private String host;

    @Column(nullable = false)
    private int port;

    private String schemaName;

    @Column(nullable = false)
    private String databaseName;

    @Column(nullable = false)
    private String username;

    @Column(length = 4000)
    private String encryptedPassword;

    private boolean SslEnabled;
    private String Ss1Mode;

    private String status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DatabaseVendor getDatabaseVendor() {
        return DatabaseVendor;
    }

    public void setDatabaseVendor(DatabaseVendor databaseVendor) {
        this.DatabaseVendor = DatabaseVendor;
    }


    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }


    public String getSchemaName() {
        return schemaName;
    }

    public void setSchemaName(String schemaName) {
        this.schemaName = schemaName;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public boolean isSslEnabled() {
        return SslEnabled;
    }

    public void setSslEnabled(boolean SslEnabled) {
        this.SslEnabled = SslEnabled;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }

    public String get5s1Mode() {
        return Ss1Mode;
    }

    public void setSs1Mode(String Ss1Mode) {
        this.Ss1Mode = Ss1Mode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}