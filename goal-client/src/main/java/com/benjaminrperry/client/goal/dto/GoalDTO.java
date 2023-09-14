package com.benjaminrperry.client.goal.dto;

import com.benjaminrperry.client.goal.Goal;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class GoalDTO implements Goal, Serializable {
    private final Integer id;
    private final String description;
    private final boolean completed;

    @Override
    public void setCompleted(boolean completed) {
        throw new RuntimeException("Cannot set completed GoalDTO is read only");
    }
}
