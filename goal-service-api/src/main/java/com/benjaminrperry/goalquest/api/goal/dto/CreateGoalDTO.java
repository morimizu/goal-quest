package com.benjaminrperry.goalquest.api.goal.dto;

import com.benjaminrperry.goalquest.api.task.dto.CreateTaskDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateGoalDTO {
    private String description;
    private List<CreateTaskDTO> tasks;
}
