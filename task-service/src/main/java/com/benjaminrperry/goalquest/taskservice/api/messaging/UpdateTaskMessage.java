package com.benjaminrperry.goalquest.taskservice.api.messaging;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class UpdateTaskMessage implements Serializable {
    private Long taskId;
    private Integer orderIndex;
    private String description;
}
