package com.valerijovich.springsecurityproject.rest;

import com.valerijovich.springsecurityproject.model.Developer;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

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
    @PreAuthorize("hasAuthority('developers:read')")
    public List<Developer> getAll() {
        return DEVELOPERS;
    }

    // создаём эндпоинт для получения одного конкретного разработчика по его id
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('developers:read')")
    public Developer getById(@PathVariable Long id) {
        return DEVELOPERS.stream().filter(developer -> developer.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    // получение нового разработчика из POST запроса и добавление его в коллекцию
    @PostMapping
    @PreAuthorize("hasAuthority('developers:write')")
    public Developer create(@RequestBody Developer developer) {
        this.DEVELOPERS.add(developer);
        return developer;
    }

    // удаление разработчика по указанному id
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('developers:write')")
    public void deleteById(@PathVariable Long id) {
        this.DEVELOPERS.removeIf(developer -> developer.getId().equals(id));
    }
}
