package com.valerijovich.springsecurityproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;

// модель разработчика
@Data
@AllArgsConstructor
public class Developer {
    private Long id;
    private String firstName;
    private String lastName;
}
