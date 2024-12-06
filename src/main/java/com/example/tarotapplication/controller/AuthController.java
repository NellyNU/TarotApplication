package com.example.tarotapplication.controller;

import com.example.tarotapplication.model.User;
import com.example.tarotapplication.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthController {
    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login() {
        return "login";  // Убедитесь, что страница login существует
    }

    @GetMapping("/register")
    public String registerForm(User user) {
        return "register";  // Страница для регистрации
    }

    @PostMapping("/register")
    public String registerUser(User user) {
        userService.registerNewUser(user);
        return "redirect:/auth/login";  // После регистрации перенаправляем на страницу логина
    }
}
