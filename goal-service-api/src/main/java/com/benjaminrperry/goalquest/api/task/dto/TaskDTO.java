package com.benjaminrperry.goalquest.api.task.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
public class TaskDTO implements Serializable {
    private Long id;
    private String description;
    private boolean completed;
    private LocalDate dueDate;
    private LocalDateTime completionDate;
}

