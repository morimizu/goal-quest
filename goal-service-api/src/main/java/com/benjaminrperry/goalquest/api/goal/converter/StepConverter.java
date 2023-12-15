package com.benjaminrperry.goalquest.api.goal.converter;

import com.benjaminrperry.goalquest.api.goal.Step;
import com.benjaminrperry.goalquest.api.goal.dto.StepDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class StepConverter {
    public static StepDto toDto(Step step) {
        return StepDto.builder()
                .id(step.getId())
                .description(step.getDescription())
                .dueDate((step.getDueDate()== null) ? "" : step.getDueDate().toString())
                .completed(step.isCompleted())
                .completionDate(step.getCompletionDate())
                .build();
    }
}
