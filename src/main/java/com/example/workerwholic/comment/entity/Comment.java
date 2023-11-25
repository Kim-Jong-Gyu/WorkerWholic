package com.example.workerwholic.comment.entity;

import com.example.workerwholic.comment.dto.CommentRequestDto;
import com.example.workerwholic.common.entity.Time;
import com.example.workerwholic.post.entity.Post;
import com.example.workerwholic.user.entity.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "comment")
@NoArgsConstructor
public class Comment extends Time {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String text;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private Comment parent;      // 상위 댓글

    @NotNull
    private Long topParentId;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @NotNull
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    @NotNull
    private Post post;

    public Comment(CommentRequestDto requestDto, User user, Post post) {
        this.text = requestDto.getText();
        this.post = post;
        this.user = user;
    }

    public void update(CommentRequestDto requestDto) {
        this.text = requestDto.getText();
    }
}