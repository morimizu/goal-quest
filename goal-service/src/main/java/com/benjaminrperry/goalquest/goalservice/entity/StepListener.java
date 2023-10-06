package com.benjaminrperry.goalquest.goalservice.entity;

import com.benjaminrperry.goalquest.goalservice.service.TaskService;
import jakarta.persistence.PrePersist;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class StepListener {

    private final TaskService taskService;

    @PrePersist
    private void onCreate(StepJpa stepJpa) {
        taskService.createTask(stepJpa.getGoal().getId(), stepJpa.getDescription(), stepJpa.getOrderIndex());
    }

}
