package com.example.workerwholic.user.controller;

import com.example.workerwholic.user.dto.ProfileRequestDto;
import com.example.workerwholic.user.dto.ResponseSignupDto;
import com.example.workerwholic.user.dto.SignupRequestDto;
import com.example.workerwholic.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    @PostMapping("/user/signup")
    public ResponseSignupDto signup(@RequestBody SignupRequestDto requestDto){
        return userService.signup(requestDto);

    }

    @PatchMapping("/user/patch-mapping/{id}")
    public Long updateUser(@PathVariable Long id, @RequestBody ProfileRequestDto requestDto){
        return  userService.updateUser(id, requestDto);
    }
}
