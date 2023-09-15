package com.benjaminrperry.goalservice.converter;

import com.benjaminrperry.goalquest.api.goal.Goal;
import com.benjaminrperry.goalquest.api.goal.dto.GoalDTO;
import com.benjaminrperry.goalservice.entity.GoalJpa;
import lombok.experimental.UtilityClass;

@UtilityClass
public class GoalConverter {
    public static GoalDTO toGoalDTO(Goal goal) {
        return GoalDTO.builder()
                .id(goal.getId())
                .description(goal.getDescription())
                .completed(goal.isCompleted())
                .build();
    }
    public static Goal toGoal(GoalDTO dto) {
        return GoalJpa.builder()
                .id(dto.getId())
                .description(dto.getDescription())
                .completed(dto.isCompleted())
                .build();
    }
}
