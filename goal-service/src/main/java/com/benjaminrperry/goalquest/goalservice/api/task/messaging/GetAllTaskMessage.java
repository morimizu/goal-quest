package com.benjaminrperry.goalquest.goalservice.api.task.messaging;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class GetAllTaskMessage implements Serializable {
    @Builder.Default
    private boolean getAllTaskMessage = true;
}
