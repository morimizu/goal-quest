package com.benjaminrperry.goalquest.api.goal.converter;

import com.benjaminrperry.goalquest.api.goal.Goal;
import com.benjaminrperry.goalquest.api.goal.Step;
import com.benjaminrperry.goalquest.api.goal.dto.GoalDTO;
import com.benjaminrperry.goalquest.api.goal.dto.StepDto;
import lombok.experimental.UtilityClass;

import java.util.List;


@UtilityClass
public class GoalConverter {
    public static GoalDTO toGoalDTO(Goal goal) {
        return GoalDTO.builder()
                .id(goal.getId())
                .type(goal.getType().name())
                .active(goal.isActive())
                .steps(convertSteps(goal.getSteps()))
                .build();
    }
    private static List<StepDto> convertSteps(List<Step> steps) {
        return steps.stream()
                .map(StepConverter::toDto)
                .toList();
    }
}
