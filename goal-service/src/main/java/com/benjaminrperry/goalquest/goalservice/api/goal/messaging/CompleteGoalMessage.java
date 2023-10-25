package com.benjaminrperry.goalquest.goalservice.api.goal.messaging;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CompleteGoalMessage {
    private Integer goalId;
}
