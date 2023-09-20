package com.benjaminrperry.goalquest.api.goal.messaging;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateGoalMessage {
    private Integer goalId;
    private String description;
}
