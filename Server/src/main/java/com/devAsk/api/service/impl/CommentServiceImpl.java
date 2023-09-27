package com.devAsk.api.service.impl;

import com.devAsk.api.dto.request.CommentRequest;
import com.devAsk.api.dto.response.CommentResponse;
import com.devAsk.api.entity.Comment;
import com.devAsk.api.entity.Solution;
import com.devAsk.api.entity.User;
import com.devAsk.api.exception.EntityNotFoundException;
import com.devAsk.api.mapper.CommentMapper;
import com.devAsk.api.repository.CommentRepository;
import com.devAsk.api.repository.QuestionRepository;
import com.devAsk.api.repository.SolutionRepository;
import com.devAsk.api.service.CommentService;
import com.devAsk.api.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    // services
    private final UserService userService;

    // repositories
    private QuestionRepository questionRepository;
    private SolutionRepository solutionRepository;
    private CommentRepository commentRepository;

    // mappers
    private CommentMapper commentMapper;


    @Override
    public List<CommentResponse> getAllForQuestion(long questionId) {
        return null;
    }

    @Override
    public List<CommentResponse> getAllForSolution(long solutionId) {
        return null;
    }

    @Override
    public CommentResponse getDetail(long commentId) {
        return null;
    }

    @Override
    public CommentResponse createForQuestion(long questionId, CommentRequest dto) {
        return null;
    }

    @Override
    public CommentResponse createForSolution(long solutionId, CommentRequest dto) {
//        Solution solution = solutionRepository.findById(solutionId);
        return null;
    }

    @Override
    public CommentResponse edit(long commentId, CommentRequest dto) throws IllegalAccessException {
        Comment comment = commentRepository
                .findById(commentId)
                .orElseThrow(() -> new EntityNotFoundException("Comment with this id not found"));

        User user = (User) userService
                .userDetailsService()
                .loadUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName());

        if (comment.getUser().getId() != user.getId())
            throw new IllegalAccessException("You are not authorized to edit this solution");

        comment.setContent(dto.getContent());

        return commentMapper.commentToResponse(comment);

    }

    @Override
    public void delete(long commentId) throws IllegalAccessException {
        Comment comment = commentRepository
                .findById(commentId)
                .orElseThrow(() -> new EntityNotFoundException("Comment with this id not found"));

        User user = (User) userService
                .userDetailsService()
                .loadUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName());

        if (comment.getUser().getId() != user.getId())
            throw new IllegalAccessException("You are not authorized to edit this solution");

        commentRepository.deleteById(commentId);
    }
}
