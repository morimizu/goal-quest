package com.benjaminrperry.client.goal.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateGoalDTO {
    private final String description;
}
