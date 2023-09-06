package com.benjaminrperry.goalservice.messaging;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class CreateGoalMessage implements Serializable {
    private String description;
}
