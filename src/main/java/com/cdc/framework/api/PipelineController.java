package com.cdc.framework.api;

import com.cdc.framework.entity.CdcPipeLineConfig;
import com.cdc.framework.entity.TrackedTableEntity;
import com.cdc.framework.dto.CreatePipelineRequest;
import com.cdc.framework.service.EmbeddedDebeziumEngineService;
import com.cdc.framework.service.PipelineService;
import com.cdc.framework.service.TableSelectionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pipeline")
@Tag(name = "Pipeline API", description = "API for managing the data pipeline")
public class PipelineController {

    private static final Logger log = LoggerFactory.getLogger(PipelineController.class);

    private final PipelineService pipelineService;
    private final TableSelectionService tableSelectionService;
    private final EmbeddedDebeziumEngineService engineService;

    public PipelineController(PipelineService pipelineService, TableSelectionService tableSelectionService,
                              EmbeddedDebeziumEngineService engineService) {
        this.pipelineService = pipelineService;
        this.tableSelectionService = tableSelectionService;
        this.engineService = engineService;
    }

    @PostMapping
    @Operation(summary = "Start the data pipeline", description = "Starts the data pipeline for the specified database connection.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Data pipeline started successfully"),
            @ApiResponse(responseCode = "500", description = "Failed to start data pipeline")
    })
    public ResponseEntity<String> startPipeline(@Valid @RequestBody CreatePipelineRequest request) {
        log.info("Starting data pipeline for database connection: {}", request.getDatabaseId());
        return pipelineService.create(request);
    }

    @GetMapping
    @Operation(summary = "Get the status of the data pipeline", description = "Retrieves the current status of the data pipeline for the specified database connection.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Data pipeline status retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "Data pipeline not found for the specified database connection")
    })
    public List<CdcPipeLineConfig> all() {
        List<CdcPipeLineConfig> pipelines = pipelineService.all();
        log.info("Retrieved {} data pipelines", pipelines.size());
        return pipelines;
    }

    @GetMapping("/id")
    @Operation(summary = "Get the status of the data pipeline by ID", description = "Retrieves the current status of the data pipeline for the specified pipeline ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Data pipeline status retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "Data pipeline not found for the specified ID")
    })
    public CdcPipeLineConfig getById(
            @Parameter(description = "The ID of the data pipeline to retrieve", example = "pipeline-123", required = true)
            @PathVariable("id") String id) {
        log.info("Fetching data pipeline status for ID: {}", id);
        return pipelineService.get(id);
    }

    @PutMapping("/{id}/tables")
    @Operation(summary = "Update the selected tables for the data pipeline", description = "Updates the selected tables for the data pipeline based on the provided list of table names.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Selected tables updated successfully"),
            @ApiResponse(responseCode = "404", description = "Data pipeline not found for the specified ID"),
            @ApiResponse(responseCode = "500", description = "Failed to update selected tables for the data pipeline")
    })
    public List<TrackedTableEntity> selectTables(
            @Parameter(description = "The ID of the data pipeline to update", example = "pipeline-123", required = true)
            @PathVariable("id") String id,
            @Valid @RequestBody CreatePipelineRequest.TableSelectionRequest request) {
        log.info("Updating selected tables for data pipeline ID: {}", id);
        return tableSelectionService.replaceSelection(id, request.getTableNames());
    }

    @GetMapping("/{id}/tables")
    @Operation(summary = "Get the selected tables for the data pipeline", description = "Retrieves the list of selected tables for the data pipeline based on the provided pipeline ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Selected tables retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "Data pipeline not found for the specified ID")
    })
    public List<TrackedTableEntity> getSelectedTables(
            @Parameter(description = "The ID of the data pipeline to retrieve selected tables for", example = "pipeline-123", required = true)
            @PathVariable("id") String id) {
        log.info("Fetching selected tables for data pipeline ID: {}", id);
        return tableSelectionService.getSelectedTables(id);
    }

    @PostMapping("/{id}/start")
    @Operation(summary = "Start the Debezium engine for the data pipeline", description = "Starts the Debezium engine for the data pipeline based on the provided pipeline ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Debezium engine started successfully"),
            @ApiResponse(responseCode = "404", description = "Data pipeline not found for the specified ID"),
            @ApiResponse(responseCode = "500", description = "Failed to start Debezium engine for the data pipeline")
    })
    public Map<String, String> startDebeziumEngine(
            @Parameter(description = "The ID of the data pipeline to start the Debezium engine for", example = "pipeline-123", required = true)
            @PathVariable("id") String id) {
        log.info("Starting Debezium engine for data pipeline ID: {}", id);
        engineService.start(id);
        return engineService.status(id);
    }

    @PostMapping("/{id}/stop")
    @Operation(summary = "Stop the Debezium engine for the data pipeline", description = "Stops the Debezium engine for the data pipeline based on the provided pipeline ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Debezium engine stopped successfully"),
            @ApiResponse(responseCode = "404", description = "Data pipeline not found for the specified ID"),
            @ApiResponse(responseCode = "500", description = "Failed to stop Debezium engine for the data pipeline")
    })
    public Map<String, String> stop(
            @Parameter(description = "The ID of the data pipeline to stop the Debezium engine for", example = "pipeline-123", required = true)
            @PathVariable("id") String id) {
        log.info("Stopping Debezium engine for data pipeline ID: {}", id);
        engineService.stop(id);
        return engineService.status(id);
    }

    @GetMapping("/{id}/status")
    @Operation(summary = "Get the status of the Debezium engine for the data pipeline", description = "Retrieves the current status of the Debezium engine for the data pipeline based on the provided pipeline ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Debezium engine status retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "Data pipeline not found for the specified ID")
    })
    public Map<String, String> status(
            @Parameter(description = "The ID of the data pipeline to retrieve Debezium engine status for", example = "pipeline-123", required = true)
            @PathVariable("id") String id) {
        log.info("Fetching Debezium engine status for data pipeline ID: {}", id);
        return engineService.status(id);
    }
}
