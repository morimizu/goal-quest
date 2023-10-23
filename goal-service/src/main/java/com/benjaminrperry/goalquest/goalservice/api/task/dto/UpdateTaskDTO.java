package com.benjaminrperry.goalquest.goalservice.api.task.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateTaskDTO {
    private Integer orderIndex;
    private String description;
}
