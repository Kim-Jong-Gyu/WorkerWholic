package com.example.workerwholic.comment.service;

import com.example.workerwholic.comment.dto.CommentRequestDto;
import com.example.workerwholic.comment.dto.CommentResponseDto;
import com.example.workerwholic.comment.entity.Comment;
import com.example.workerwholic.comment.repository.CommentRepository;
import com.example.workerwholic.common.constant.UserRoleEnum;
import com.example.workerwholic.post.entity.Post;
import com.example.workerwholic.post.repository.PostRepository;
import com.example.workerwholic.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.hibernate.boot.model.naming.IllegalIdentifierException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    public CommentResponseDto createComment(CommentRequestDto requestDto, User user) {
        if (requestDto.getPostId() == null) {
            throw new IllegalIdentifierException("카드를 선택해주세요.");
        }
        Post post = postRepository.findById(requestDto.getPostId()).orElseThrow(() -> new IllegalIdentifierException("선택한 카드는 존재하지 않습니다."));
        Comment saveComment = commentRepository.save(new Comment(requestDto, user, post));
        return new CommentResponseDto(saveComment);
    }

    @Transactional
    public CommentResponseDto updateComment(Long id, CommentRequestDto requestDto, User user) {
        // DB에 존재하는지 확인
        Comment comment = commentRepository.findById(id).orElseThrow(() -> new IllegalIdentifierException("선택한 댓글이 존재하지 않습니다."));
        if (!isAccessableUser(user, comment.getUser())) {
            throw new IllegalIdentifierException("작성자만 삭제/수정할 수 있습니다");
        }

        comment.update(requestDto);
        return new CommentResponseDto(comment);
    }

    public ResponseEntity deleteComment(Long id, User user) {
        // DB에 존재하는지 확인
        Comment comment = commentRepository.findById(id).orElseThrow(() -> new IllegalIdentifierException("선택한 댓글이 존재하지 않습니다."));
        if (!isAccessableUser(user, comment.getUser())) {
            throw new IllegalIdentifierException("작성자만 삭제/수정할 수 있습니다");
        }

        commentRepository.delete(comment);
        return new ResponseEntity("댓글이 삭제되었습니다", HttpStatus.OK);
    }

    public Page<CommentResponseDto> getCommentsInPost(Long postId, int page) {
        int size = 30;
        Sort sort = Sort.by("topParentId", "id");
        Pageable pageable = PageRequest.of(page, size, sort);

        Page<Comment> productList = commentRepository.findAllByPostId(postId, pageable);

        Page<CommentResponseDto> responseDtoList = productList.map(CommentResponseDto::new);

        return responseDtoList;
    }

    private boolean isAccessableUser(User target_user, User access_user) {
        if (target_user == null || access_user == null) {
            return false;
        }

        if (access_user.getRole() == UserRoleEnum.ADMIN || access_user.getId().equals(target_user.getId())) {
            return true;
        }

        return false;
    }

}