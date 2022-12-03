package me.jaejoon.server.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
public class ServerController {


    @GetMapping("/username")
    public String getName() {
        return "jaejoon";
    }

    @GetMapping("/username/timeout")
    public String timeout() throws InterruptedException {
        log.info("username sleep start");
        Thread.sleep(3000);
        log.info("username sleep end");

        return "jaejoon";
    }

}
