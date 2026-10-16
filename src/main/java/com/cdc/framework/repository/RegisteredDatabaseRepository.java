package com.cdc.framework.repository;

import com.cdc.framework.entity.RegisteredDatabaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisteredDatabaseRepository extends JpaRepository<RegisteredDatabaseEntity, String> {
    // You can add custom query methods here if needed
    // Example: List<RegisteredDatabaseEntity> findByName(String name);
}
