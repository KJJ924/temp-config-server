package me.jaejoon.client.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.cloud.bootstrap.config.PropertySourceLocator;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class ApplicationInitTest implements ApplicationRunner {

    @Autowired
    ApplicationContext applicationContext;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        PropertySourceLocator bean = applicationContext.getBean(PropertySourceLocator.class);
        System.out.println(bean);
    }
}
