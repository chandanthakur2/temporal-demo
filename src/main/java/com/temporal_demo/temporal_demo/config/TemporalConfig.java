package com.temporal_demo.temporal_demo.config;

import io.temporal.client.WorkflowClient;
import io.temporal.serviceclient.WorkflowServiceStubs;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TemporalConfig {

    @Bean
    public WorkflowServiceStubs workflowServiceStubs() {
        try {
            return WorkflowServiceStubs.newInstance();
        } catch (Exception e) {
            // Log the exception or handle it as needed
            System.err.println("Failed to connect to Temporal service: " + e.getMessage());
            return null; // Return null to indicate failure
        }
    }

    @Bean
    public WorkflowClient workflowClient(WorkflowServiceStubs service) {
        if (service == null) {
            // Temporal service connection failed, handle accordingly
            // For example, you can provide a dummy or fallback WorkflowClient
            // Here, we simply return null, but you might want to implement a fallback strategy
            return null;
        }
        return WorkflowClient.newInstance(service);
    }
}
