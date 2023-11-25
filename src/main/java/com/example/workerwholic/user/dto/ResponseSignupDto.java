package com.example.workerwholic.user.dto;

import com.example.workerwholic.user.entity.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseSignupDto {
    private long userId;
    public ResponseSignupDto(User user) {
        this.userId = user.getId();
    }
}
