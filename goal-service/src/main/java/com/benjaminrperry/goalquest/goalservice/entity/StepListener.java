package com.benjaminrperry.goalquest.goalservice.entity;

import com.benjaminrperry.goalquest.goalservice.service.TaskService;
import jakarta.persistence.PrePersist;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
public class StepListener {

    private final TaskService taskService;

    @PrePersist
    private void onCreate(StepJpa stepJpa) {
        if(taskService != null) {
            taskService.createTaskFromStep(stepJpa);
        }

    }

}
