package com.cdc.framework.entity;

import com.cdc.framework.dto.BaseAuditable;
import com.cdc.framework.utils.DatabaseVendor;
import jakarta.persistence.*;
import lombok.Data;



@Data
@Table(name="registered_database")
    public class RegisteredDatabaseEntity extends BaseAuditable {
        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        private String id;
        @Column(nullable = false, unique = true)
        private String name;
        @Column(nullable = false)
        private String host;
        @Enumerated(EnumType.STRING)
        @Column(nullable = false)
        private DatabaseVendor databaseVendor;


        @Column(nullable = false)
        private int port;
        @Column(nullable = false)
        private String databaseName;
        private String schemaName;
        @Column(nullable = false)
        private String username;
        @Column(length = 4000)
        private String encryptedPassword;
        private boolean sslEnabled;
        private String sslMode;
        private String status;




    }
