package com.example.workerwholic.comment.dto;

import lombok.Getter;

@Getter
public class CommentRequestDto {
    private Long postId;
    private String text;
    private Long parentId;
}