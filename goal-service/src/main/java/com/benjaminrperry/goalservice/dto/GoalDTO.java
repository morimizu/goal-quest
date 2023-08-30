package com.benjaminrperry.goalservice.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GoalDTO {
    private final Integer id;
    private final String description;
    private final boolean completed;
}
