package me.jaejoon.client.refresh;

import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@RefreshScope
@Component
@ToString
public class JaeJoonBean {

    @Value("${name}")
    private String name;

    @Value("${location}")
    private String location;

}
