package com.benjaminrperry.goalquest.goalservice.listener;

import com.benjaminrperry.goalquest.goalservice.entity.StepJpa;
import com.benjaminrperry.goalquest.goalservice.event.CreateStepEvent;
import jakarta.persistence.PostPersist;
import lombok.NoArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

@NoArgsConstructor
public class StepListener implements ApplicationEventPublisherAware {
    private ApplicationEventPublisher publisher;

    @PostPersist
    private void onCreate(StepJpa step) {
        publisher.publishEvent(new CreateStepEvent(step));
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher = applicationEventPublisher;
    }
}
