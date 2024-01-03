package com.benjaminrperry.goalquest.api.task.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
public class TaskDTO implements Serializable {
    private Long id;
    private Long stepId;
    private String description;
    private boolean completed;
    private LocalDateTime completionDate;
}

