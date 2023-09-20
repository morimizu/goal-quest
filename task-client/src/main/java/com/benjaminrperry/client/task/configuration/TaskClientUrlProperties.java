package com.benjaminrperry.client.task.configuration;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import java.util.Map;

@EnableConfigurationProperties(TaskClientUrlProperties.class)
@ConfigurationProperties("goalquest")
@RequiredArgsConstructor
@Getter
public class TaskClientUrlProperties {
    private final Map<String,ClientSettings> client;

    @EnableConfigurationProperties(ClientSettings.class)
    @ConfigurationProperties("client")
    @RequiredArgsConstructor()
    @Getter
    public static class ClientSettings {
        private final ServerSettings server;
        private Map<String, String> urls;
    }
        public record ServerSettings(String host, String port) {
    }
}
