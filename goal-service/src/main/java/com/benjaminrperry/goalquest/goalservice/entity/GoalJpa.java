package com.benjaminrperry.goalquest.goalservice.entity;

import com.benjaminrperry.goalquest.goalservice.api.goal.Goal;
import com.benjaminrperry.goalquest.goalservice.api.goal.GoalType;
import com.benjaminrperry.goalquest.goalservice.api.goal.Step;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "goals")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GoalJpa implements Goal, Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type")
    private GoalType type;

    @Builder.Default
    @Column(name = "active")
    private boolean active = false;

    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    @Override
    public void setActive(boolean active) {
        this.active = active;
    }

    @OneToMany(targetEntity = StepJpa.class, mappedBy = "goal_id")
    private List<Step> steps;

    @Override
    public void setSteps(List<Step> steps) {
        this.steps = steps;
    }

    @Override
    public void addStep(Step step) {
        if(!(step instanceof StepJpa)){
            throw new RuntimeException("step must be an entity to be added");
        }
        if(steps == null){
            steps = new ArrayList<>();
        }
        steps.add(step);
    }


}
