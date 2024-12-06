package com.example.tarotapplication.service;

import com.example.tarotapplication.model.User;
import com.example.tarotapplication.model.UserLuck;
import com.example.tarotapplication.repository.UserLuckRepository;
import com.example.tarotapplication.repository.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserLuckService {
    private final UserLuckRepository userLuckRepository;
    private final UserRepository userRepository;

    // Constructor for dependency injection
    public UserLuckService(UserLuckRepository userLuckRepository, UserRepository userRepository) {
        this.userLuckRepository = userLuckRepository;
        this.userRepository = userRepository;
    }

    public UserLuck addLuck(UserLuck userLuck) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByUsername(username);
        userLuck.setUser(user);
        return userLuckRepository.save(userLuck);
    }

    public Integer getCurrentUserLuck() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByUsername(username);
        return userLuckRepository.findTopByUserOrderByDateAddedDesc(user)
                .map(UserLuck::getLuckScore)
                .orElse(0);
    }
}