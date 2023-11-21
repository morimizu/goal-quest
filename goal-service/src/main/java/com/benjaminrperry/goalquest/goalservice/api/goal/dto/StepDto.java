package com.benjaminrperry.goalquest.goalservice.api.goal.dto;

import com.benjaminrperry.goalquest.goalservice.api.goal.Goal;
import com.benjaminrperry.goalquest.goalservice.api.goal.Step;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class StepDto {
    private Long id;
    private String description;
    private LocalDateTime dueDate;
    private boolean completed;
    private LocalDateTime completionDate;
}
