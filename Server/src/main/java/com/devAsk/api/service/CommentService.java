package com.devAsk.api.service;

import com.devAsk.api.dto.request.CommentRequest;
import com.devAsk.api.dto.response.CommentResponse;
import com.devAsk.api.entity.Comment;

import java.util.List;

public interface CommentService {
    List<CommentResponse> getAllForQuestion(long questionId);
    List<CommentResponse> getAllForSolution(long solutionId);
    CommentResponse getDetail(long commentId);
    CommentResponse createForQuestion(long questionId, CommentRequest dto);
    CommentResponse createForSolution(long solutionId, CommentRequest dto);
    CommentResponse edit(long commentId,CommentRequest dto) throws IllegalAccessException;
    void delete(long commentId) throws IllegalAccessException;
}
