package com.example.tarotapplication.repository;

import com.example.tarotapplication.model.User;
import com.example.tarotapplication.model.UserLuck;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserLuckRepository extends JpaRepository<UserLuck, Long> {
    Optional<UserLuck> findTopByUserOrderByDateAddedDesc(User user);
}