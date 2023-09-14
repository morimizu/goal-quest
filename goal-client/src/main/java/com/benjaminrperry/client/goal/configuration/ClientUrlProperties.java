package com.benjaminrperry.client.goal.configuration;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import java.util.Map;

@EnableConfigurationProperties(ClientUrlProperties.class)
@ConfigurationProperties("goalquest")
@RequiredArgsConstructor
@Getter
public class ClientUrlProperties {
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
