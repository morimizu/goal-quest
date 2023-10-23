package com.benjaminrperry.goalquest.goalservice.converter;

import com.benjaminrperry.goalquest.goalservice.api.goal.Goal;
import com.benjaminrperry.goalquest.goalservice.api.goal.Step;
import com.benjaminrperry.goalquest.goalservice.api.goal.dto.GoalDTO;
import com.benjaminrperry.goalquest.goalservice.api.goal.dto.StepDto;
import com.benjaminrperry.goalquest.goalservice.entity.GoalJpa;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class GoalConverter {
    public static GoalDTO toGoalDTO(Goal goal) {
        return GoalDTO.builder()
                .id(goal.getId())
                .description(goal.getDescription())
                .completed(goal.isCompleted())
                .steps(convertSteps(goal.getSteps()))
                .build();
    }
    private static List<StepDto> convertSteps(List<Step> steps) {
        return steps.stream()
                .map(StepConverter::toDto)
                .toList();
    }
    public static Goal toGoal(GoalDTO dto) {
        return GoalJpa.builder()
                .id(dto.getId())
                .description(dto.getDescription())
                .completed(dto.isCompleted())
                .build();
    }
}
