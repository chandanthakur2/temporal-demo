package com.temporal_demo.temporal_demo.temporal.activities;
import io.temporal.activity.ActivityInterface;
import io.temporal.activity.ActivityMethod;

@ActivityInterface
public interface DataSyncActivities {

    @ActivityMethod
    void validateData();

    @ActivityMethod
    void processData();

    @ActivityMethod
    void syncDataToDestination();
}

