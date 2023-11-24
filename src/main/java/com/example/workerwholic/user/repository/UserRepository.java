package com.example.workerwholic.user.repository;

import com.example.workerwholic.common.constant.UserRoleEnum;
import com.example.workerwholic.user.dto.LoginRequestDto;
import com.example.workerwholic.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
    List<User> findAllByRole(UserRoleEnum roleEnum);
}
