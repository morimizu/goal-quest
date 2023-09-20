package com.benjaminrperry.goalquest.api.task.messaging;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class CompleteTaskMessage implements Serializable {
    private Long taskId;
}
