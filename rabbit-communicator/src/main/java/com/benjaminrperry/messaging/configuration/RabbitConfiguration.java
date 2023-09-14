package com.benjaminrperry.messaging.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class RabbitConfiguration {
    private final AppRabbitConfigProperties rabbitConfigProperties;

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(rabbitConfigProperties.getExchangeName());
    }

    @Bean
    public Queue queue() {
        var name = rabbitConfigProperties.getBindings().get("goal").getQueueName();
        return new Queue(name);
    }

    @Bean
    public Binding exchangeBinding() {
        var routingKey = rabbitConfigProperties.getBindings().get("goal").getQueueName();
        return BindingBuilder
                .bind(queue())
                .to(topicExchange())
                .with(routingKey);
    }


}
