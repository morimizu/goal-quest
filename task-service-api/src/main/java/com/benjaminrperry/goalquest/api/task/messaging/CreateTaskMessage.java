package com.benjaminrperry.goalquest.api.task.messaging;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class CreateTaskMessage implements Serializable {
    private Long goalId;
    private Integer orderIndex;
    private String description;
}
