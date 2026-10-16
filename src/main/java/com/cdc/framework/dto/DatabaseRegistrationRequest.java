package com.cdc.framework.dto;

import com.cdc.framework.utils.DatabaseVendor;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatabaseRegistrationRequest(
        @NotBlank String name,
        String description,
        @NotNull DatabaseVendor databaseVendor,
        @NotBlank String host,
        @Min(1) int port,
        @NotBlank String databaseName,
        String schemaName,
        @NotBlank String username,
        @NotBlank String password,
        boolean sslEnabled,
        String sslMode
) {}
