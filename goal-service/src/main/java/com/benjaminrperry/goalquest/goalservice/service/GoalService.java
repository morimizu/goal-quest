package com.benjaminrperry.goalquest.goalservice.service;

import com.benjaminrperry.goalquest.api.goal.Goal;
import com.benjaminrperry.goalquest.api.goal.GoalType;
import com.benjaminrperry.goalquest.api.goal.Step;
import com.benjaminrperry.goalquest.api.goal.dto.CreateStepDto;
import com.benjaminrperry.goalquest.goalservice.entity.GoalJpa;
import com.benjaminrperry.goalquest.goalservice.entity.StepJpa;
import com.benjaminrperry.goalquest.goalservice.event.CreateStepEvent;
import com.benjaminrperry.goalquest.goalservice.repository.GoalRepository;
import com.benjaminrperry.goalquest.goalservice.repository.StepRepository;
import com.benjaminrperry.goalquest.goalservice.repository.TaskRepository;
import jakarta.persistence.PostPersist;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class GoalService {
    private final GoalRepository goalRepository;
    private final StepRepository stepRepository;
    private final TaskService taskService;

    public Goal createGoal(String type, List<CreateStepDto> stepList) {
        log.info("creating new goal of type: "+ type);
        GoalType goalType = GoalType.valueOf(type);
        GoalJpa goal = GoalJpa.builder()
                .type(goalType)
                .build();
        goal = goalRepository.save(goal);
        final var savedGoal = goal;
        var steps = stepList.stream()
                .map(step -> (Step) createStep(savedGoal, step))
                .toList();
        goal.setSteps(steps);
        return goal;

    }

    private StepJpa createStep(GoalJpa goal,CreateStepDto stepDto){
        StepJpa step = new StepJpa();
        step.setGoal(goal);
        step.setDescription(stepDto.getDescription());
        step.setDueDate(LocalDate.parse(stepDto.getDueDate(), DateTimeFormatter.ISO_LOCAL_DATE));
        step = stepRepository.save(step);
        return step;
    }

    public Optional<Goal> findGoalById(Integer id) {
        return goalRepository.findById(id).map(goal -> (Goal) goal);
    }

    public List<Goal> findAllGoals() {
        return goalRepository.findAll().stream().map(goal -> (Goal) goal).toList();
    }


    @EventListener
    public void onCreateStepEvent(CreateStepEvent event) {
        this.taskService.createTaskFromStep(event.getStep());
    }
}
