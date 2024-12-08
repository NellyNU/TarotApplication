package com.example.tarotapplication.service;

import com.example.tarotapplication.model.User;
import com.example.tarotapplication.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public User registerNewUser(User user) {
        // Проверка существования пользователя
        if (userRepository.existsByUsername(user.getUsername())) {
            throw new RuntimeException("Пользователь с таким именем уже существует");
        }

        // Проверка существования email (если требуется)
        if (userRepository.findByEmail(user.getEmail()) != null) {
            throw new RuntimeException("Пользователь с таким email уже существует");
        }

        // Пароль сохраняется "как есть", шифрование удалено
        user.setPassword(user.getPassword());

        // Сохранение пользователя
        return userRepository.save(user);
    }
}
