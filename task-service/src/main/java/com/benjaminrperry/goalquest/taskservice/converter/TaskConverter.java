package com.benjaminrperry.goalquest.taskservice.converter;

import com.benjaminrperry.goalquest.taskservice.api.dto.TaskDTO;
import com.benjaminrperry.goalquest.taskservice.entity.task.Task;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TaskConverter {
    public static TaskDTO toDto(Task model) {
        return TaskDTO.builder()
                .id(model.getId())
                .goalId(model.getGoalId())
                .description(model.getDescription())
                .orderIndex(model.getOrderIndex())
                .complete(model.isComplete())
                .build();
    }
}
