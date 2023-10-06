package com.benjaminrperry.goalquest.api.goal.dto;

import com.benjaminrperry.goalquest.api.goal.Step;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StepDto implements Step {
    private Long id;
    private Long goal;
    private String description;
    private Integer orderIndex;
    private boolean completed;
}
