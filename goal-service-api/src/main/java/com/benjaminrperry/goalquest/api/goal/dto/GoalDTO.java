package com.benjaminrperry.goalquest.api.goal.dto;


import com.benjaminrperry.goalquest.api.goal.Goal;
import com.benjaminrperry.goalquest.api.task.dto.TaskDTO;
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
public class GoalDTO implements Goal, Serializable {
    private Long id;
    private String description;
    private boolean completed;
    private List<TaskDTO> tasks;

    @Override
    public void setCompleted(boolean completed) {
        throw new RuntimeException("Cannot set completed GoalDTO is read only");
    }
}
