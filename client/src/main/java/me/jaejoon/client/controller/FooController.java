package me.jaejoon.client.controller;

import java.util.List;
import me.jaejoon.client.config.PersonConfig;
import me.jaejoon.client.config.PersonConfig.Person;
import me.jaejoon.client.refresh.JaeJoonBean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FooController {

    private final JaeJoonBean jaeJoonBean;
    private final PersonConfig persons;

    public FooController(JaeJoonBean jaeJoonBean, PersonConfig persons) {
        this.jaeJoonBean = jaeJoonBean;
        this.persons = persons;
    }

    @GetMapping("/status/jaejoon/been")
    public ResponseEntity<String> getJaeJoon() {
        System.out.println(jaeJoonBean);
        return ResponseEntity.ok("hi");
    }


    @GetMapping("/status/persons")
    public List<Person> getPersons() {
        System.out.println(persons);
        return persons.getPersons();
    }
}
