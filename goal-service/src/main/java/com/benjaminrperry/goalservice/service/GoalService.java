package com.benjaminrperry.goalservice.service;

import com.benjaminrperry.goalservice.api.Goal;
import com.benjaminrperry.goalservice.entity.GoalJpa;
import com.benjaminrperry.goalservice.repository.GoalRepository;
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

    public Goal createGoal(String description) {
        log.info("creating new goal with descr: "+ description);
        GoalJpa goal = GoalJpa.builder()
                .description(description)
                .build();
        return goalRepository.save(goal);
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
}
