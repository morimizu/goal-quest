package com.benjaminrperry.goalservice;

import com.benjaminrperry.messaging.configuration.AppRabbitConfigProperties;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication
@ComponentScan(basePackages = {"com.benjaminrperry.goalservice", "com.benjaminrperry.messaging", "com.benjaminrperry.client"})
@EnableWebFlux
@EnableRabbit
public class GoalServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GoalServiceApplication.class, args);
    }

}
