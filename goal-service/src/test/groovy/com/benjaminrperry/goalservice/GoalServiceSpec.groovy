package com.benjaminrperry.goalservice

import com.benjaminrperry.goalquest.goalservice.api.goal.GoalType
import com.benjaminrperry.goalquest.goalservice.api.goal.dto.CreateStepDto
import com.benjaminrperry.goalquest.goalservice.entity.GoalJpa
import com.benjaminrperry.goalquest.goalservice.entity.StepJpa
import com.benjaminrperry.goalquest.goalservice.entity.task.TaskJpa
import com.benjaminrperry.goalquest.goalservice.repository.GoalRepository
import com.benjaminrperry.goalquest.goalservice.repository.StepRepository
import com.benjaminrperry.goalquest.goalservice.repository.TaskRepository
import com.benjaminrperry.goalquest.goalservice.service.GoalService
import spock.lang.Specification

import java.time.LocalDateTime


class GoalServiceSpec extends Specification {

    def goalRepo = Mock(GoalRepository)

    def stepRep = Mock(StepRepository)

    def taskRepo = Mock(TaskRepository)

    def service = new GoalService(goalRepo, stepRep, taskRepo)

    def 'goal is created in db'() {
        given:
        def desc = "do this thing in 2 days"
        def newGoalId = 1L
        def newStepId = 2L
        def newTaskId = 3L
        def expectedUnsavedSavedStep = buildStep(desc)
        def expectedSavedStep = buildStep(newStepId, newGoalId, desc)
        def expectedUnsavedGoal = buildGoal(null, GoalType.COMPLETE_BY, [expectedUnsavedSavedStep])
        def expectedSavedGoal = buildGoal(newGoalId, GoalType.COMPLETE_BY, [expectedSavedStep])
        def expectedSavedTask = buildTask(newTaskId, newStepId, desc)
        when:
        service.createGoal(GoalType.COMPLETE_BY.name(), [
                CreateStepDto.builder()
                        .description(desc)
                        .dueDate(LocalDateTime.now().plusDays(2))
                        .build()
        ])

        then:
        1 * goalRepo.save(expectedUnsavedGoal) >> expectedSavedGoal
        1 * stepRep.save(expectedUnsavedSavedStep) >> expectedSavedStep
        1 * taskRepo.createTask(newStepId , desc) >> expectedSavedTask
    }

    GoalJpa buildGoal(id, type, steps) {
        GoalJpa.builder()
                .id(id)
                .type(type)
                .steps(steps)
                .build()
    }

    StepJpa buildStep(description) {
        buildStep(null, description)
    }

    StepJpa buildStep(goalId, description) {
        buildStep(null, goalId,description)
    }

    StepJpa buildStep(id, goalId, description) {
        StepJpa.builder()
                .id(id)
                .goal(GoalJpa.builder()
                        .id(goalId)
                        .build())
                .description(description)
                .build()
    }

    TaskJpa buildTask(id, stepId, description) {
        TaskJpa.builder()
                .id(id)
                .stepId(stepId)
                .description(description)
                .completed(false)
                .completionDate(null)
                .build()
    }

}