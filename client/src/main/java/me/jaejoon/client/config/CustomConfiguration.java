package me.jaejoon.client.config;

import me.jaejoon.client.locator.CustomConfigServicePropertySourceLocator;
import org.springframework.cloud.config.client.ConfigClientProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomConfiguration {

    private final ConfigClientProperties configClientProperties;

    public CustomConfiguration(ConfigClientProperties configClientProperties) {
        this.configClientProperties = configClientProperties;
    }

    @Bean
    public CustomConfigServicePropertySourceLocator customConfigServicePropertySourceLocator() {
        return new CustomConfigServicePropertySourceLocator(configClientProperties);
    }

}
