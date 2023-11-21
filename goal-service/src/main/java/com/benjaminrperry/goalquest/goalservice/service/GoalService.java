package com.benjaminrperry.goalquest.goalservice.service;

import com.benjaminrperry.goalquest.goalservice.api.goal.Goal;
import com.benjaminrperry.goalquest.goalservice.api.goal.GoalType;
import com.benjaminrperry.goalquest.goalservice.api.goal.Step;
import com.benjaminrperry.goalquest.goalservice.api.goal.dto.CreateStepDto;
import com.benjaminrperry.goalquest.goalservice.entity.GoalJpa;
import com.benjaminrperry.goalquest.goalservice.entity.StepJpa;
import com.benjaminrperry.goalquest.goalservice.repository.GoalRepository;
import com.benjaminrperry.goalquest.goalservice.repository.StepRepository;
import com.benjaminrperry.goalquest.goalservice.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class GoalService {
    private final GoalRepository goalRepository;
    private final StepRepository stepRepository;
    private final TaskRepository taskRepository;

    public Goal createGoal(String type, List<CreateStepDto> stepList) {
        log.info("creating new goal of type: "+ type);
        GoalType goalType = GoalType.valueOf(type);
        GoalJpa goal = GoalJpa.builder()
                .type(goalType)
                .steps(stepList.stream()
                        .map(step -> (Step) createStep(step))
                        .toList())
                .build();
        return goalRepository.save(goal);

    }

    private StepJpa createStep(CreateStepDto stepDto){
        StepJpa step = new StepJpa();
        step.setDescription(stepDto.getDescription());
        step.setDueDate(stepDto.getDueDate());
        return step;
    }

    public Optional<Goal> findGoalById(Integer id) {
        return goalRepository.findById(id).map(goal -> (Goal) goal);
    }

    public List<Goal> findAllGoals() {
        return goalRepository.findAll().stream().map(goal -> (Goal) goal).toList();
    }


}
