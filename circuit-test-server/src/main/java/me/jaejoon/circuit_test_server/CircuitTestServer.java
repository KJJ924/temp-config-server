package me.jaejoon.circuit_test_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableHystrix
public class CircuitTestServer {

    public static void main(String[] args) {
        SpringApplication.run(CircuitTestServer.class, args);
    }
}
