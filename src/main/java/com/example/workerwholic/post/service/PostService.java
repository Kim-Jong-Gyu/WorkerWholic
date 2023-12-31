package com.example.workerwholic.post.service;

import com.example.workerwholic.location.entity.Location;
import com.example.workerwholic.location.repository.LocationRepository;
import com.example.workerwholic.post.dto.PostRequestDto;
import com.example.workerwholic.post.dto.PostResponseDto;
import com.example.workerwholic.post.entity.Post;
import com.example.workerwholic.post.repository.PostRepository;
import com.example.workerwholic.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final LocationRepository locationRepository;
    public PostResponseDto createPost(User user, PostRequestDto postRequestDto) {
        Location location = findLocation(postRequestDto.getLocationId());
        Post post = postRepository.save(new Post(user, postRequestDto, location));
        return new PostResponseDto(post);
    }

    public PostResponseDto getPost(Long id) {
        return new PostResponseDto(findPost(id));
    }

    public Map<String, List<PostResponseDto>> getPosts() {
        Map<String, List<PostResponseDto>> userPostMap = new HashMap<>();
        List<Post> postList = postRepository.findAllByOrderByCreatedAtDesc();
        postList.forEach(post -> {
            if(userPostMap.containsKey(post.getUser().getUsername())){
                userPostMap.get(post.getUser().getUsername()).add(new PostResponseDto(post));
            }
            else{
                userPostMap.put(post.getUser().getUsername(), new ArrayList<>(List.of(new PostResponseDto(post))));
            }
        });
        return userPostMap;
    }

    public List<PostResponseDto> getUserPosts(User user) {
        List<Post> postList = postRepository.findAllByUserId(user.getId());
        return postList.stream().map(PostResponseDto :: new).toList();
    }

    @Transactional
    public PostResponseDto updatePost(User user, Long id, PostRequestDto postRequestDto) {
        Post post = findPost(id);
        if(Objects.equals(post.getUser().getId(), user.getId())){
            post.update(postRequestDto);
        }
        else {
            throw new IllegalArgumentException("일치하지 않는 유저입니다.");
        }
        return new PostResponseDto(post);
    }

    public PostResponseDto deletePost(User user, Long postId) {
        Post post = findPost(postId);
        if(!user.getId().equals(post.getUser().getId())){
            throw new IllegalArgumentException("일치하지 않는 유저입니다.");
        }
        postRepository.delete(post);
        return new PostResponseDto(post);
    }

    private Post findPost(Long id) {
        return postRepository.findById(id).orElseThrow(() ->
                new NullPointerException("게시글이 없습니다.")
        );
    }
    private Location findLocation(Long id) {
        return locationRepository.findById(id).orElseThrow(() ->
                new NullPointerException("해당 지역이 없습니다.")
        );
    }
}
