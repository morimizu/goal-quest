package com.benjaminrperry.goalservice;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.benjaminrperry.messaging")
@EnableRabbit
public class GoalServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GoalServiceApplication.class, args);
    }

}
