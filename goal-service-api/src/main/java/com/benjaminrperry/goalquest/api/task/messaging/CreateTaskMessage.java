package com.benjaminrperry.goalquest.api.task.messaging;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Builder
public class CreateTaskMessage implements Serializable {
    private String description;
    private LocalDate dueDate;
}
