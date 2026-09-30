package com.cdc.framework.repository;

import com.cdc.framework.entity.CdcPipeLineConfig;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CdcPipelineConfigRepository extends JpaRepository<CdcPipeLineConfig, String> {
}
