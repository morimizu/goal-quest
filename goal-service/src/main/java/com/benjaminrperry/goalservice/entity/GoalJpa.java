package com.benjaminrperry.goalservice.entity;

import com.benjaminrperry.goalquest.api.goal.Goal;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "goal")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GoalJpa implements Goal, Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "description")
    private String description;

    @Column(name = "completed")
    private boolean completed = false;

    @Override
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
