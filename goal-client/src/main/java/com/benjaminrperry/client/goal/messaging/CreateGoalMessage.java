package com.benjaminrperry.client.goal.messaging;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class CreateGoalMessage implements Serializable {
    private String description;
}
