package com.cdc.framework.service;

import com.cdc.framework.dto.CdcChangeEvent;
import com.cdc.framework.dto.DatabaseRegistrationRequest;
import java.util.ArrayList;
import java.util.List;

import com.cdc.framework.entity.RegisteredDatabaseEntity;
import org.springframework.stereotype.Service;

public interface DatabaseRegistryService   {


    RegisteredDatabaseEntity register(DatabaseRegistrationRequest req);
    List<RegisteredDatabaseEntity> all();
    RegisteredDatabaseEntity get(String id);

}
