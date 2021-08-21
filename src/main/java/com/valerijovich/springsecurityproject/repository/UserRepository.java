package com.valerijovich.springsecurityproject.repository;

import com.valerijovich.springsecurityproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// интерфейс, который будет взаимодействовать с БД
public interface UserRepository extends JpaRepository<User, Long> {

    // поиск пользователя по емейлу
    Optional<User> findByEmail(String email);
}
