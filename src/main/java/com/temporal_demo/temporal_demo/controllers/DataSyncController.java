package com.temporal_demo.temporal_demo.controllers;

import com.temporal_demo.temporal_demo.services.DataSyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataSyncController {

    @Autowired
    private DataSyncService dataSyncService;

    @GetMapping("/start-data-sync")
    public String startDataSync(@RequestParam String type) {
        dataSyncService.startWorkflow(type);
        return "Data sync workflow started for type: " + type;
    }
}
