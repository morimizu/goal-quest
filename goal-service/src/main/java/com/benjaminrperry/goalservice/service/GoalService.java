package com.benjaminrperry.goalservice.service;

import com.benjaminrperry.goalservice.api.Goal;
import com.benjaminrperry.goalservice.entity.GoalJpa;
import com.benjaminrperry.goalservice.repository.GoalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GoalService {
    private final GoalRepository goalRepository;

    public Goal createGoal(String description) {
        Goal goal = GoalJpa.builder()
                .description(description)
                .build();
        return goalRepository.save(goal);
    }

    public Optional<Goal> findGoalById(Integer id) {
        return goalRepository.findById(id);
    }

    public List<Goal> findAllGoals() {
        return goalRepository.findAll();
    }

    public Goal completeGoal(Integer id) {
        Optional<Goal> goal = findGoalById(id);
        if(goal.isPresent()){
            goal.get().setCompleted(true);
            return goalRepository.save(goal.get());
        }
        return null;
    }
}
