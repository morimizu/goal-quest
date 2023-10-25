package com.benjaminrperry.goalquest.goalservice.api.goal.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateGoalDTO {
    private String description;
    private List<CreateStepDto> steps;
}
