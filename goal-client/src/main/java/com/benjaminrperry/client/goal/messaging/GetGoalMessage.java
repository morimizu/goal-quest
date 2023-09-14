package com.benjaminrperry.client.goal.messaging;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GetGoalMessage {
    private Integer goalId;
}
