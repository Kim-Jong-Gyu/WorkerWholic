package com.example.workerwholic.post.entity;

import com.example.workerwholic.location.entity.Location;
import com.example.workerwholic.post.dto.PostRequestDto;
import com.example.workerwholic.user.entity.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "post")
@NoArgsConstructor
public class Post extends Time {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column
    private String content;

    @Column
    private String img;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "location_id", nullable = false)
    private Location location;

    public Post(User user, PostRequestDto postRequestDto, Location location) {
        this.title = postRequestDto.getTitle();
        this.content = postRequestDto.getContent();
        this.img = postRequestDto.getImg();
        this.user = user;
        this.location = location;
    }

    public void update(PostRequestDto postRequestDto) {
        this.title = postRequestDto.getTitle();
        this.content = postRequestDto.getContent();
        this.img = postRequestDto.getImg();
    }
}
