package com.benjaminrperry.goalquest.goalservice.converter;

import com.benjaminrperry.goalquest.goalservice.api.goal.Step;
import com.benjaminrperry.goalquest.goalservice.api.goal.dto.StepDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class StepConverter {
    public static StepDto toDto(Step step) {
        return StepDto.builder()
                .id(step.getId())
                .description(step.getDescription())
                .dueDate(step.getDueDate())
                .completed(step.isCompleted())
                .completionDate(step.getCompletionDate())
                .build();
    }
}
