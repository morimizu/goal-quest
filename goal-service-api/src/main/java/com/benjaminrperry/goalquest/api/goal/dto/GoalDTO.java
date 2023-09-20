package com.benjaminrperry.goalquest.api.goal.dto;


import com.benjaminrperry.goalquest.api.goal.Goal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GoalDTO implements Goal, Serializable {
    private Integer id;
    private String description;
    private boolean completed;

    @Override
    public void setCompleted(boolean completed) {
        throw new RuntimeException("Cannot set completed GoalDTO is read only");
    }
}
