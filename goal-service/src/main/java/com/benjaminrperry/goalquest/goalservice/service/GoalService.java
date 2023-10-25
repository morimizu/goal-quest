package com.benjaminrperry.goalquest.goalservice.service;

import com.benjaminrperry.goalquest.goalservice.api.goal.Goal;
import com.benjaminrperry.goalquest.goalservice.api.goal.Step;
import com.benjaminrperry.goalquest.goalservice.api.goal.dto.CreateStepDto;
import com.benjaminrperry.goalquest.goalservice.api.task.Task;
import com.benjaminrperry.goalquest.goalservice.api.task.dto.CreateTaskDTO;
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

    public Goal createGoal(String description, List<CreateStepDto> stepList) {
        log.info("creating new goal with descr: "+ description);
        GoalJpa goal = GoalJpa.builder()
                .description(description)
                .steps(stepList.stream()
                        .map(step -> createStep(step, stepList.indexOf(step)))
                        .toList())
                .build();
        goal = goalRepository.save(goal);
        return goal;

    }

    private Step createStep(CreateStepDto stepDto, Integer order){
        StepJpa step = new StepJpa();
        step.setDescription(stepDto.getDescription());
        step.setOrderIndex(order);
        return (Step) step;
    }

    public Optional<Goal> findGoalById(Integer id) {
        return goalRepository.findById(id).map(goal -> (Goal) goal);
    }

    public List<Goal> findAllGoals() {
        return goalRepository.findAll().stream().map(goal -> (Goal) goal).toList();
    }

    public Goal completeGoal(Integer id) {
        Optional<Goal> goal = findGoalById(id);
        if(goal.isPresent()){
            goal.get().setCompleted(true);
            return goalRepository.save((GoalJpa) goal.get());
        }
        return null;
    }

    public List<Task> getGoalTasks(Long goalId) {
       return taskRepository.getTasksForGoal(goalId);
    }

    private List<Task> createTaskList(List<CreateTaskDTO> taskList) {
        return taskList.stream()
                .map(dto -> taskRepository.createTask(dto.getGoalId(), dto.getDescription(), dto.getOrderIndex()))
                .toList();
    }
}
