package com.example.workerwholic.post.repository;

import com.example.workerwholic.post.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Arrays;
import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByOrderByCreatedAtDesc();
    
    List<Post> findAllByUserId(Long id);
}
