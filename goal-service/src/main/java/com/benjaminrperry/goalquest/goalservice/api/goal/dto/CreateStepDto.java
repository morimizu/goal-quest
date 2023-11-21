package com.benjaminrperry.goalquest.goalservice.api.goal.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateStepDto {
    private String description;
    private LocalDateTime dueDate;
}
