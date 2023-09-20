package com.benjaminrperry.goalquest.taskservice.api.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateTaskDTO {
    private Long goalId;
    private Integer orderIndex;
    private String description;
}
