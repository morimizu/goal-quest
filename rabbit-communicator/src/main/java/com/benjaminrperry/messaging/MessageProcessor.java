package com.benjaminrperry.messaging;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;

@RabbitListener(queues = "${app.rabbit.queue-name}")
public interface MessageProcessor<T> {

    @RabbitHandler
    T processMessage(@Payload T message);
}
