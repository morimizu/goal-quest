package com.benjaminrperry.goalquest.goalservice.entity;

import com.benjaminrperry.goalquest.api.goal.Goal;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "step")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(StepListener.class)
public class StepJpa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(targetEntity = GoalJpa.class)
    @JoinColumn(name = "goal_id")
    private Goal goal;

    @Column(name = "description")
    private String description;

    @Column(name = "completed")
    private boolean completed;

    @Column(name = "order")
    private Integer orderIndex;
}
