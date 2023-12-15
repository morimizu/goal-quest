package com.benjaminrperry.goalquest.api.goal.messaging;

import com.benjaminrperry.goalquest.api.goal.dto.CreateStepDto;
import com.benjaminrperry.goalquest.api.task.dto.CreateTaskDTO;
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
