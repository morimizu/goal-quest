package com.benjaminrperry.goalquest.api.task.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateTaskDto implements Serializable {
    private String description;
    private String dueDate;
}
