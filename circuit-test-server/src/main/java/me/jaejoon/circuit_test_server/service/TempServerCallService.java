package me.jaejoon.circuit_test_server.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class TempServerCallService {

    private final RestTemplate restTemplate;

    @HystrixCommand(commandKey = "userName", fallbackMethod = "getCircuitUserName")
    public String userName() {
        return restTemplate.getForObject("/username", String.class);
    }


    @HystrixCommand(commandKey = "userName", fallbackMethod = "getCircuitUserName")
    public String userNameSleep() {
        return restTemplate.getForObject("/username/timeout", String.class);
    }

    public String getCircuitUserName() {
        return "fallback Jaejoon";
    }
}
