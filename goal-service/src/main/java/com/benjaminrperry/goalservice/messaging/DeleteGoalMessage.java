package com.benjaminrperry.goalservice.messaging;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DeleteGoalMessage {
    private Integer goalId;
}
