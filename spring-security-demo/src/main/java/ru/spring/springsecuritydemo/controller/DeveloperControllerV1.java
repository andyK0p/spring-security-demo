package ru.spring.springsecuritydemo.controller;

import org.springframework.web.bind.annotation.*;
import ru.spring.springsecuritydemo.model.Developer;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/v1/developers")
public class DeveloperControllerV1 {

    private List<Developer> DEVELOPERS = Stream.of(
        new Developer(1L, "Ivan", "Ivanov"),
        new Developer(2L, "Sergey", "Sergeev"),
        new Developer(3L, "Petr", "Petrov")
    ).collect(Collectors.toList());

    @GetMapping
    public List<Developer> getAll() {
        return DEVELOPERS;
    }

    @GetMapping("/{id}")
    public Developer getDeveloperById(@PathVariable("id") Long id) {
        return DEVELOPERS.stream().filter(developer -> developer.getId().equals(id)).findFirst().orElse(null);
    }

    @PostMapping
    public Developer create(@RequestBody Developer developer) {
        DEVELOPERS.add(developer);
        return developer;
    }

    @DeleteMapping("/{id}")
    public void deleteDeveloperById(@PathVariable("id") Long id) {
        DEVELOPERS.removeIf(developer -> developer.getId().equals(id));
    }
}
