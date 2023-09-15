package com.benjaminrperry.goalquest;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication
@ComponentScan(basePackages = {"com.benjaminrperry.goalquest.controller", "com.benjaminrperry.messaging", "com.benjaminrperry.client"})
@EnableWebFlux
@EnableRabbit
public class GoalQuestRestGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GoalQuestRestGatewayApplication.class, args);
    }

}
