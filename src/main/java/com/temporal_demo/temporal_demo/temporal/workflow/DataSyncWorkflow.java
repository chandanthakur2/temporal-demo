package com.temporal_demo.temporal_demo.temporal.workflow;

import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;

@WorkflowInterface
public interface DataSyncWorkflow {

    @WorkflowMethod
    void execute(String type);
}
