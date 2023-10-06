package com.benjaminrperry.goalquest.goalservice.converter;

import com.benjaminrperry.goalquest.api.goal.Goal;
import com.benjaminrperry.goalquest.api.goal.Step;
import com.benjaminrperry.goalquest.api.goal.dto.GoalDTO;
import com.benjaminrperry.goalquest.api.goal.dto.StepDto;
import com.benjaminrperry.goalquest.api.task.Task;
import com.benjaminrperry.goalquest.api.task.converter.TaskConverter;
import com.benjaminrperry.goalquest.api.task.dto.TaskDTO;
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
    private static List<Step> convertSteps(List<Step> steps) {
        return steps.stream()
                .map(StepConverter::toDto)
                .map(step -> (Step) step)
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
