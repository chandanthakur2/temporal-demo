package com.temporal_demo.temporal_demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WorkflowController {

    @GetMapping("/workflow")
    public String startWorkflow() {
        return "Workflow started";
    }
}
