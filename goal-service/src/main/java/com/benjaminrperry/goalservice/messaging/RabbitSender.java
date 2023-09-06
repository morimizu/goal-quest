package com.benjaminrperry.goalservice.messaging;

import com.benjaminrperry.goalservice.configuration.AppRabbitConfigProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class RabbitSender {
    private final AppRabbitConfigProperties rabbitConfigProperties;
    private final RabbitTemplate rabbitTemplate;

    public void send(String exchangeName, String routingKey, Object message){
        rabbitTemplate.convertAndSend(exchangeName, routingKey, message);
    }

    public Object sendAndReceive(String exchangeName, String routingKey, Object message){
        return rabbitTemplate.convertSendAndReceive(exchangeName, routingKey, message);
    }

    public void send(Object message){
        rabbitTemplate.convertAndSend(rabbitConfigProperties.getExchangeName(), rabbitConfigProperties.getRoutingKey(), message);
    }

    public Object sendAndReceive(Object message){
        log.info("attempting to convert and send/receive message: "+ message.toString());
        return rabbitTemplate.convertSendAndReceive(rabbitConfigProperties.getExchangeName(), rabbitConfigProperties.getRoutingKey(), message);
    }
}
