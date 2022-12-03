package me.jaejoon.circuit_test_server.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class TempServerCallService {

    private final RestTemplate restTemplate;

    public String userName() {
        return restTemplate.getForObject("/username", String.class);
    }


    public String userNameSleep() {
        return restTemplate.getForObject("/username/timeout", String.class);
    }
}
