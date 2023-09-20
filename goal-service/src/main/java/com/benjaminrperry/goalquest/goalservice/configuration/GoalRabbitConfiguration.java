package com.benjaminrperry.goalquest.goalservice.configuration;

import com.benjaminrperry.messaging.configuration.AppRabbitConfigProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class GoalRabbitConfiguration {
    private final AppRabbitConfigProperties rabbitConfigProperties;
    private final TopicExchange topicExchange;

    @Bean
    public Queue goalQueue() {
        var name = rabbitConfigProperties.getBindings().get("goal").getQueueName();
        return new Queue(name);
    }

    @Bean
    public Binding goalBinding() {
        var routingKey = rabbitConfigProperties.getBindings().get("goal").getRoutingKey();
        return BindingBuilder
                .bind(goalQueue())
                .to(topicExchange)
                .with(routingKey);
    }
}
