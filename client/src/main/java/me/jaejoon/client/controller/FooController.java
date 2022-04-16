package me.jaejoon.client.controller;

import lombok.RequiredArgsConstructor;
import me.jaejoon.client.refresh.JaeJoonBean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class FooController {

    private final JaeJoonBean jaeJoonBean;

    @GetMapping("/status/jaejoon/been")
    public ResponseEntity<String> getJaeJoon() {
        System.out.println(jaeJoonBean);
        return ResponseEntity.ok("hi");
    }
}
