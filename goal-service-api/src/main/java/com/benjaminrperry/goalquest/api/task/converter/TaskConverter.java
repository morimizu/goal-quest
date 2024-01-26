package com.benjaminrperry.goalquest.api.task.converter;

import com.benjaminrperry.goalquest.api.task.Task;
import com.benjaminrperry.goalquest.api.task.dto.CreateTaskDto;
import com.benjaminrperry.goalquest.api.task.dto.TaskDTO;
import com.benjaminrperry.goalquest.api.task.messaging.CreateTaskMessage;
import lombok.experimental.UtilityClass;

import java.time.LocalDate;

@UtilityClass
public class TaskConverter {
    public static TaskDTO toDto(Task model) {
        return TaskDTO.builder()
                .id(model.getId())
                .description(model.getDescription())
                .dueDate(model.getDueDate())
                .completed(model.isCompleted())
                .build();
    }

    public static CreateTaskMessage toMessage(CreateTaskDto createTaskDto) {
        var dueDate = isEmpty(createTaskDto.getDueDate()) ? null : LocalDate.parse(createTaskDto.getDueDate());
        return CreateTaskMessage.builder()
                .description(createTaskDto.getDescription())
                .dueDate(dueDate)
                .build();
    }

    private static boolean isEmpty(String string) {
        return string == null || string.isEmpty();
    }
}
