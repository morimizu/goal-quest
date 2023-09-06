package com.benjaminrperry.goalservice;

import com.benjaminrperry.goalservice.configuration.AppRabbitConfigProperties;
import com.benjaminrperry.goalservice.messaging.RabbitGoalClient;
import com.benjaminrperry.goalservice.messaging.RabbitSender;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableRabbit
public class GoalServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GoalServiceApplication.class, args);
    }

}
