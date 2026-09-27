package com.cdc.framework.repository;

import com.cdc.framework.dto.CdcChangeEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CdcChangeEventRepository extends JpaRepository<CdcChangeEvent, String> {
}
