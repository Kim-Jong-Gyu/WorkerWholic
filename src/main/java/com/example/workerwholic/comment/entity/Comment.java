package com.example.workerwholic.comment.entity;

import com.example.workerwholic.comment.dto.CommentRequestDto;
import com.example.workerwholic.post.entity.Time;
import com.example.workerwholic.post.entity.Post;
import com.example.workerwholic.user.entity.User;
import jakarta.persistence.*;
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

    @Column(nullable = false)
    private String text;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Comment parent;      // 상위 댓글

    @Column
    private Long topParentId;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "post_id")
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