package com.example.workerwholic.user.controller;

import com.example.workerwholic.user.dto.ProfileRequestDto;
import com.example.workerwholic.user.dto.SignupRequestDto;
import com.example.workerwholic.user.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user/login-page")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/user/signup")
    public String signupPage() {
        return "signup";
    }
    @PostMapping("/user/signup")
    public String signup(@RequestBody SignupRequestDto requestDto){
        userService.signup(requestDto);

        return "redirect:/api/user/login-page";
    }

    @PatchMapping("/user/patch-mapping/{id}")
    @ResponseBody
    public Long updateUser(@PathVariable Long id, @RequestBody ProfileRequestDto requestDto){
        return  userService.updateUser(id, requestDto);
    }
}
