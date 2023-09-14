package com.benjaminrperry.messaging.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;

@Configuration
@ConfigurationProperties(prefix = "goalquest.rabbit")
@Getter
@Setter
public class AppRabbitConfigProperties {
    private String exchangeName;
    private LinkedHashMap<String, QueueBinding> bindings;

    @Getter
    @Setter
    public static class QueueBinding {
        private String queueName;
        private String routingKey;

    }
}
