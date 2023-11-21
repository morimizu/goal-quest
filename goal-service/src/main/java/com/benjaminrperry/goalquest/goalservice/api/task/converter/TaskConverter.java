package com.benjaminrperry.goalquest.goalservice.api.task.converter;

import com.benjaminrperry.goalquest.goalservice.api.task.Task;
import com.benjaminrperry.goalquest.goalservice.api.task.dto.TaskDTO;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TaskConverter {
    public static TaskDTO toDto(Task model) {
        return TaskDTO.builder()
                .id(model.getId())
                .stepId(model.getStepId())
                .description(model.getDescription())
                .completed(model.isCompleted())
                .build();
    }
}
