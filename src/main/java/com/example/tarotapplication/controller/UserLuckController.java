package com.example.tarotapplication.controller;

import com.example.tarotapplication.model.UserLuck;
import com.example.tarotapplication.service.UserLuckService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/luck")
public class UserLuckController {
    private final UserLuckService userLuckService;

    // Constructor for dependency injection
    public UserLuckController(UserLuckService userLuckService) {
        this.userLuckService = userLuckService;
    }

    @PostMapping("/add")
    public UserLuck addLuck(@RequestBody UserLuck userLuck) {
        return userLuckService.addLuck(userLuck);
    }

    @GetMapping("/current")
    public Integer getCurrentLuck() {
        return userLuckService.getCurrentUserLuck();
    }
}