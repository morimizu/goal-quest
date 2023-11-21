package com.benjaminrperry.goalquest.goalservice.api.goal.messaging;

import com.benjaminrperry.goalquest.goalservice.api.goal.GoalType;
import com.benjaminrperry.goalquest.goalservice.api.goal.dto.CreateStepDto;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
public class CreateGoalMessage implements Serializable {
    private String type;
    private List<CreateStepDto> stepList;
}
