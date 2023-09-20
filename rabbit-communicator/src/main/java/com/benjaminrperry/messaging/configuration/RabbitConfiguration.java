package com.benjaminrperry.messaging.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class RabbitConfiguration {
    protected final AppRabbitConfigProperties rabbitConfigProperties;

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(rabbitConfigProperties.getExchangeName());
    }




}
