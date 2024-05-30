package com.temporal_demo.temporal_demo.services;

import com.temporal_demo.temporal_demo.temporal.workflow.DataSyncWorkflow;
import io.temporal.client.WorkflowClient;
import io.temporal.client.WorkflowOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataSyncService {

    @Autowired
    private WorkflowClient workflowClient;

    public void startWorkflow(String type) {
        DataSyncWorkflow workflow = workflowClient.newWorkflowStub(DataSyncWorkflow.class,
                WorkflowOptions.newBuilder()
                        .setTaskQueue("DATA_SYNC_TASK_QUEUE")
                        .build());

        WorkflowClient.start(workflow::execute, type);
    }
}

