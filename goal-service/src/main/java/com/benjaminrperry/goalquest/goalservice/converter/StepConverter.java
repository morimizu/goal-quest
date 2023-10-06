package com.benjaminrperry.goalquest.goalservice.converter;

import com.benjaminrperry.goalquest.api.goal.Step;
import com.benjaminrperry.goalquest.api.goal.dto.StepDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class StepConverter {
    public static StepDto toDto(Step step) {
        return StepDto.builder()
                .id(step.getId())
                .goal(step.getGoal().getId())
                .description(step.getDescription())
                .orderIndex(step.getOrderIndex())
                .completed(step.isCompleted())
                .build();
    }
}
