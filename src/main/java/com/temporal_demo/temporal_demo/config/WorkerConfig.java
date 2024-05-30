package com.temporal_demo.temporal_demo.config;

import com.temporal_demo.temporal_demo.temporal.activities.DataSyncActivitiesImpl;
import com.temporal_demo.temporal_demo.temporal.workflow.DataSyncWorkflowImpl;
import io.temporal.client.WorkflowClient;
import io.temporal.worker.Worker;
import io.temporal.worker.WorkerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WorkerConfig {

    @Autowired
    private WorkflowClient workflowClient;

    @Bean
    public WorkerFactory workerFactory() {
        WorkerFactory factory = WorkerFactory.newInstance(workflowClient);
        Worker worker = factory.newWorker("DATA_SYNC_TASK_QUEUE");
        worker.registerWorkflowImplementationTypes(DataSyncWorkflowImpl.class);
        worker.registerActivitiesImplementations(new DataSyncActivitiesImpl());
        factory.start();
        return factory;
    }
}

