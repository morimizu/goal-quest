package com.benjaminrperry.goalservice.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateGoalDTO {
    private final String description;
}
