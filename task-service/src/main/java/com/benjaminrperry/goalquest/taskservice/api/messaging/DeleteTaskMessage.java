package com.benjaminrperry.goalquest.taskservice.api.messaging;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class DeleteTaskMessage implements Serializable {
    private Long taskId;
}
