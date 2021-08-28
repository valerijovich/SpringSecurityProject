package com.valerijovich.springsecurityproject.rest;

import lombok.Data;

// класс для логина и пароля (для аутентификации)
@Data
public class AuthenticationRequestDTO {
    private String email;
    private String password;
}
