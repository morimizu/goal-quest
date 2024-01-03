package com.benjaminrperry.goalquest.goalservice.event;

import com.benjaminrperry.goalquest.goalservice.entity.StepJpa;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CreateStepEvent {
    private final StepJpa step;
}
