package com.benjaminrperry.goalquest.api.task.dto;

import com.benjaminrperry.goalquest.api.task.Task;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TaskDTO implements Task {
    private Long id;
    private Long goalId;
    private Integer orderIndex;
    private String description;
    private boolean complete;
}
