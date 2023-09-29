package com.benjaminrperry.goalquest.goalservice.converter;

import com.benjaminrperry.goalquest.api.goal.Goal;
import com.benjaminrperry.goalquest.api.goal.dto.GoalDTO;
import com.benjaminrperry.goalquest.api.task.Task;
import com.benjaminrperry.goalquest.api.task.converter.TaskConverter;
import com.benjaminrperry.goalquest.api.task.dto.TaskDTO;
import com.benjaminrperry.goalquest.goalservice.entity.GoalJpa;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class GoalConverter {
    public static GoalDTO toGoalDTO(Goal goal) {
        return toGoalDTO(goal,null);
    }
    public static GoalDTO toGoalDTO(Goal goal, List<Task> tasks) {
        return GoalDTO.builder()
                .id(goal.getId())
                .description(goal.getDescription())
                .completed(goal.isCompleted())
                .tasks(convertTasks(tasks))
                .build();
    }
    public static Goal toGoal(GoalDTO dto) {
        return GoalJpa.builder()
                .id(dto.getId())
                .description(dto.getDescription())
                .completed(dto.isCompleted())
                .build();
    }

    private static List<TaskDTO> convertTasks(List<Task> tasks) {
        return (tasks != null) ? tasks.stream().map(TaskConverter::toDto).toList() : List.of();
    }
}
