package com.valerijovich.springsecurityproject.controller;

import com.valerijovich.springsecurityproject.model.Developer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// REST контроллер приложения
@RestController
@RequestMapping("/api/v1/developers")
public class DeveloperRestControllerV1 {

    // создаём коллекцию разработчиков
    private final List<Developer> DEVELOPERS = Stream.of(
            new Developer(1L, "John", "Doe"),
            new Developer(2L, "John", "Malkovich"),
            new Developer(3L, "Tom", "Ford")
    ).collect(Collectors.toList());

    // создаём эндпоинт для получения списка всех разработчиков
    @GetMapping
    public List<Developer> getAll() {
        return DEVELOPERS;
    }

    // создаём эндпоинт для получения одного конкретного разработчика по его айди
    @GetMapping("/{id}")
    public Developer getById(@PathVariable Long id) {
        return DEVELOPERS.stream().filter(developer -> developer.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
