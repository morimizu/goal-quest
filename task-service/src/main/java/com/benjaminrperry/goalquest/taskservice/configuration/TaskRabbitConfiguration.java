package com.benjaminrperry.goalquest.taskservice.configuration;

import com.benjaminrperry.messaging.configuration.AppRabbitConfigProperties;
import com.benjaminrperry.messaging.configuration.RabbitConfiguration;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class TaskRabbitConfiguration {
    private final AppRabbitConfigProperties rabbitConfigProperties;
    private final TopicExchange topicExchange;

    @Bean
    public Queue taskQueue() {
        var name = rabbitConfigProperties.getBindings().get("task").getQueueName();
        return new Queue(name);
    }

    @Bean
    public Binding taskBinding() {
        var routingKey = rabbitConfigProperties.getBindings().get("task").getRoutingKey();
        return BindingBuilder
                .bind(taskQueue())
                .to(topicExchange)
                .with(routingKey);
    }
}
