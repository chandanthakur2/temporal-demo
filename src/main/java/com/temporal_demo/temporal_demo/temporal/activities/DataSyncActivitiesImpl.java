package com.temporal_demo.temporal_demo.temporal.activities;

public class DataSyncActivitiesImpl implements DataSyncActivities {

    @Override
    public void validateData() {
        // Logic for data validation
        System.out.println("Validating data...");
    }

    @Override
    public void processData() {
        // Logic for data processing
        System.out.println("Processing data...");
    }

    @Override
    public void syncDataToDestination() {
        // Logic for syncing data to destination
        System.out.println("Syncing data to destination...");
    }
}

