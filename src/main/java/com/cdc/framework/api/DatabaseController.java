package com.cdc.framework.api;

import com.cdc.framework.domain.RegisteredDatabaseEntity;
import com.cdc.framework.model.DatabaseRegistrationRequest;
import com.cdc.framework.model.DiscoveredTable;
import com.cdc.framework.service.CdcReadinessService;
import com.cdc.framework.service.ConnectionTestService;
import com.cdc.framework.service.DatabaseService;
import com.cdc.framework.service.MetadataDiscoveryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/database")
@Tag(name = "Database Controller", description = "Controller for database operations")
public class DatabaseController {

    private static final Logger log = LoggerFactory.getLogger(DatabaseController.class);

    private final DatabaseService registry;
    private final ConnectionTestService connectionTest;
    private final CdcReadinessService readiness;
    private final MetadataDiscoveryService discovery;

    public DatabaseController(DatabaseService registry, ConnectionTestService connectionTest,
                             CdcReadinessService readiness, MetadataDiscoveryService discovery) {
        this.registry = registry;
        this.connectionTest = connectionTest;
        this.readiness = readiness;
        this.discovery = discovery;
    }

    @PostMapping
    @Operation(summary = "Register a new database connection",
            description = "Registers a new database connection with the provided details.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Database connection registered successfully"),
            @ApiResponse(responseCode = "500", description = "Failed to register database connection")
    })
    public RegisteredDatabaseEntity register(@Valid @RequestBody DatabaseRegistrationRequest req) {
        log.info("Registering database connection: {}", req);
        return registry.register(req);
    }

    @GetMapping
    @Operation(summary = "Get all registered database connections",
            description = "Retrieves a list of all registered database connections.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved registered database connections"),
            @ApiResponse(responseCode = "500", description = "Failed to retrieve registered database connections")
    })
    public List<RegisteredDatabaseEntity> getAll() {
        log.info("Fetching all registered database connections");
        return registry.getAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a registered database connection by ID",
            description = "Retrieves a registered database connection based on its ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved the database connection"),
            @ApiResponse(responseCode = "404", description = "Database connection not found"),
            @ApiResponse(responseCode = "500", description = "Failed to retrieve the database connection")
    })
    public RegisteredDatabaseEntity getById(@PathVariable String id) {
        log.info("Fetching registered database connection by ID: {}", id);
        return registry.getById(id);
    }

    @PostMapping("/{id}/test-connection")
    @Operation(summary = "Test the connection to a registered database",
            description = "Tests the connection to a registered database connection based on its ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully tested the database connection"),
            @ApiResponse(responseCode = "404", description = "Database connection not found"),
            @ApiResponse(responseCode = "500", description = "Failed to test the database connection")
    })
    public ResponseEntity<String> testConnection(@PathVariable String id) {
        log.info("Testing connection for registered database connection: {}", id);
        if (connectionTest.testConnection(id)) {
            return ResponseEntity.ok("Database connection is valid.");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to test database connection.");
        }
    }

    @PostMapping("/{id}/CDC-readiness-check")
    @Operation(summary = "Check the readiness of a registered database for CDC",
            description = "Checks if a registered database connection is ready for Change Data Capture (CDC) based on its ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully checked the readiness of the database connection"),
            @ApiResponse(responseCode = "404", description = "Database connection not found"),
            @ApiResponse(responseCode = "500", description = "Failed to check the readiness of the database connection")
    })
    public ResponseEntity<String> checkReadiness(@PathVariable String id) {
        log.info("Checking readiness for registered database connection: {}", id);
        if (readiness.isReady(id)) {
            return ResponseEntity.ok("Database connection is ready for CDC.");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Database connection is not ready for CDC.");
        }
    }

    @GetMapping("/{id}/tables")
    @Operation(summary = "Discover tables in a registered database connection",
            description = "Discovers the tables available in a registered database connection based on its ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully discovered tables in the database connection"),
            @ApiResponse(responseCode = "404", description = "Database connection not found"),
            @ApiResponse(responseCode = "500", description = "Failed to discover tables in the database connection")
    })
    public List<DiscoveredTable> tables(
            @Parameter(description = "The ID of the registered database connection", example = "db123", required = true)
            @PathVariable("id") String id) {
        log.info("Discovering tables for registered database connection: {}", id);
        return discovery.discoverTables(id);
    }
}
