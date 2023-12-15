package com.benjaminrperry.goalquest.api.goal.dto;


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
    private String type;
    private boolean active;
    private List<StepDto> steps;
}
