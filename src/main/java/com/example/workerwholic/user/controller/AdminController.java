package com.example.workerwholic.user.controller;

import com.example.workerwholic.user.entity.User;
import com.example.workerwholic.user.filter.UserDetailsImpl;
import com.example.workerwholic.user.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class AdminController {

    private final AdminService adminService;
    @GetMapping("/admin/profilelist")
    public List<User> getProfilelist(@AuthenticationPrincipal UserDetailsImpl userDetails){
        return adminService.getProfilelist( userDetails.getUser());
    }
}
