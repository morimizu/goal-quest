package com.benjaminrperry.goalquest.goalservice.api.goal.dto;

import com.benjaminrperry.goalquest.goalservice.api.goal.Goal;
import com.benjaminrperry.goalquest.goalservice.api.goal.Step;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StepDto {
    private Long id;
    private Long goalId;
    private String description;
    private Integer orderIndex;
    private boolean completed;
}
