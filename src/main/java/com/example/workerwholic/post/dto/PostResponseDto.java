package com.example.workerwholic.post.dto;

import com.example.workerwholic.post.entity.Post;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostResponseDto {
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime modifedAt;
    private String img;

    public PostResponseDto(Post post) {
        this.title = post.getTitle();
        this.content = post.getContent();
        this.createdAt = post.getCreatedAt();
        this.modifedAt = post.getModifiedAt();
        this.img = post.getImg();
    }
}
