package com.benjaminrperry.goalquest.goalservice.api.goal.dto;


import com.benjaminrperry.goalquest.goalservice.api.goal.Goal;
import com.benjaminrperry.goalquest.goalservice.api.goal.Step;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GoalDTO implements Serializable {
    private Long id;
    private String description;
    private boolean completed;
    private List<StepDto> steps;
}
