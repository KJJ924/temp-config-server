package me.jaejoon.client.refresh;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@RefreshScope
@Component
@ConfigurationProperties("jaejoon")
public class JaeJoonBean {

    private String name;

    private String location;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "JaeJoonBean{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
