package me.jaejoon.circuit_test_server.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.jaejoon.circuit_test_server.service.TempServerCallService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class CircuitController {

    private final TempServerCallService tempServerCallService;

    @GetMapping("/username")
    public String getName() {
        return tempServerCallService.userName();
    }

    @GetMapping("/username/timeout")
    public String timeout() {
        return tempServerCallService.userNameSleep();
    }
}
