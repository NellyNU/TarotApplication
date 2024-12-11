package com.example.tarotapplication.controller;

import com.example.tarotapplication.model.User;
import com.example.tarotapplication.repository.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private final UserRepository userRepository;

    public HomeController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/home")
    public String homePage(Model model) {
        // Get the current authenticated username
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        // Fetch the user details
        User user = userRepository.findByUsername(username);

        // Add user details to the model
        model.addAttribute("user", user);

        return "home";


    }

    @GetMapping("/cards")
    public String seeCards() {
        return "game";
    }
}