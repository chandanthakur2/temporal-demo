package com.temporal_demo.temporal_demo.temporal.workflow;

import com.temporal_demo.temporal_demo.temporal.activities.DataSyncActivities;
import io.temporal.activity.ActivityOptions;
import io.temporal.workflow.Workflow;
import java.time.Duration;

public class DataSyncWorkflowImpl implements DataSyncWorkflow {

    private final DataSyncActivities activities = Workflow.newActivityStub(
            DataSyncActivities.class,
            ActivityOptions.newBuilder()
                    .setStartToCloseTimeout(Duration.ofMinutes(5))
                    .build()
    );

    @Override
    public void execute(String type) {
        activities.validateData();
        activities.processData();
        activities.syncDataToDestination();
    }
}

