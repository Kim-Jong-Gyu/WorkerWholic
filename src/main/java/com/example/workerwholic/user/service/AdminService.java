package com.example.workerwholic.user.service;

import com.example.workerwholic.user.entity.UserRoleEnum;
import com.example.workerwholic.user.entity.User;
import com.example.workerwholic.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class AdminService {
    private final UserRepository userRepository;
    public List<User> getProfilelist(User user) {
        if(user.getRole()!= UserRoleEnum.ADMIN){
            throw new IllegalArgumentException("관리자가 아닙니다.");
        }
        List<User> users = userRepository.findAllByRole(UserRoleEnum.USER);
        return users;
    }
}
