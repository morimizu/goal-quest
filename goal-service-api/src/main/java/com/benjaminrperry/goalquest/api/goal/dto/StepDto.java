package com.benjaminrperry.goalquest.api.goal.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
public class StepDto implements Serializable {
    private Long id;
    private String description;
    private String dueDate;
    private boolean completed;
    private LocalDateTime completionDate;
}
