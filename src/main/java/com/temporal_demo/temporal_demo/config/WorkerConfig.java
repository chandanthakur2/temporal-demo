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
        try {
            WorkerFactory factory = WorkerFactory.newInstance(workflowClient);
            Worker worker = factory.newWorker("DATA_SYNC_TASK_QUEUE");
            worker.registerWorkflowImplementationTypes(DataSyncWorkflowImpl.class);
            worker.registerActivitiesImplementations(new DataSyncActivitiesImpl());
            factory.start();
            return factory;
        } catch (Exception e) {
            // Log the exception or handle it as needed
            System.err.println("Failed to create WorkerFactory because temporal is not running: " + e.getMessage());
            return null; // Return null to indicate failure
        }
    }
}

