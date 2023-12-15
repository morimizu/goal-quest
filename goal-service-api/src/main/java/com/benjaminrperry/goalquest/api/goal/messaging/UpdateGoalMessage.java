package com.benjaminrperry.goalquest.api.goal.messaging;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class UpdateGoalMessage implements Serializable {
    private Integer goalId;
    private String description;
}
