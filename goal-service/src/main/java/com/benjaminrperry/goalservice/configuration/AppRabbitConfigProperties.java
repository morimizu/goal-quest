package com.benjaminrperry.goalservice.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "app.rabbit")
@Getter
@Setter
public class AppRabbitConfigProperties {
    private String exchangeName;
    private String queueName;
    private String routingKey;
}
