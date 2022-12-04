package me.jaejoon.circuit_test_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrix
@EnableHystrixDashboard
public class CircuitTestServer {

    public static void main(String[] args) {
        SpringApplication.run(CircuitTestServer.class, args);
    }
}
