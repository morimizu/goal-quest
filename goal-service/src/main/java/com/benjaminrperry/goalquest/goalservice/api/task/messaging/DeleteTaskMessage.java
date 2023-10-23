package com.benjaminrperry.goalquest.goalservice.api.task.messaging;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class DeleteTaskMessage implements Serializable {
    private Long taskId;
}
