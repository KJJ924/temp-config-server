package me.jaejoon.client.config;

import org.springframework.cloud.config.client.ConfigClientProperties;
import org.springframework.cloud.config.client.ConfigServicePropertySourceLocator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomConfigServiceBootstrapConfiguration {
    private final ConfigClientProperties configClientProperties;

    public CustomConfigServiceBootstrapConfiguration(ConfigClientProperties configClientProperties) {
        this.configClientProperties = configClientProperties;
    }


    @Bean
    public ConfigServicePropertySourceLocator configServicePropertySourceLocator() {
        return new ConfigServicePropertySourceLocator(configClientProperties);
    }
}
