package com.example.workerwholic.user.repository;

import com.example.workerwholic.user.entity.RefreshToken;
import com.example.workerwholic.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
    RefreshToken findByUsername(String username);
}
