package com.benjaminrperry.goalquest.goalservice.api.task.dto;

import com.benjaminrperry.goalquest.goalservice.api.task.Task;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class TaskDTO {
    private Long id;
    private Long stepId;
    private String description;
    private boolean completed;
    private LocalDateTime completionDate;
}
