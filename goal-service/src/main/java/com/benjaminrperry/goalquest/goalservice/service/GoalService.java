package com.benjaminrperry.goalquest.goalservice.service;

import com.benjaminrperry.client.task.messaging.RabbitTaskClient;
import com.benjaminrperry.goalquest.api.goal.Goal;
import com.benjaminrperry.goalquest.api.task.Task;
import com.benjaminrperry.goalquest.api.task.dto.CreateTaskDTO;
import com.benjaminrperry.goalquest.api.task.messaging.CreateTaskMessage;
import com.benjaminrperry.goalquest.goalservice.entity.GoalJpa;
import com.benjaminrperry.goalquest.goalservice.repository.GoalRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class GoalService {
    private final GoalRepository goalRepository;
    private final RabbitTaskClient rabbitTaskClient;

    public Goal createGoal(String description, List<CreateTaskDTO> taskList) {
        log.info("creating new goal with descr: "+ description);
        GoalJpa goal = GoalJpa.builder()
                .description(description)
                .build();
        goal = goalRepository.save(goal);
        if(taskList != null) {
            Long goalId = goal.getId();
            taskList.forEach(createTaskDTO -> createTaskDTO.setGoalId(goalId));
            createTaskList(taskList);
        }
        return goal;

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
       return rabbitTaskClient.getAllTasks().stream()
                .filter(task -> Objects.equals(task.getGoalId(), goalId))
                .toList();
    }

    private List<Task> createTaskList(List<CreateTaskDTO> taskList) {
        return taskList.stream().map(this::sendCreateTaskMessage).toList();
    }

    private Task sendCreateTaskMessage(CreateTaskDTO createTaskDTO) {
        return rabbitTaskClient.createTask(createTaskDTO.getGoalId(), createTaskDTO.getDescription(), createTaskDTO.getOrderIndex());
    }
}
