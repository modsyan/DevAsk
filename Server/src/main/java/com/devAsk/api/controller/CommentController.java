package com.devAsk.api.controller;


import com.devAsk.api.dto.request.CommentRequest;
import com.devAsk.api.dto.response.CommentResponse;
import com.devAsk.api.dto.response.SolutionResponse;
import com.devAsk.api.model.ApiResult;
import com.devAsk.api.service.CommentService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private CommentService commentService;

    @GetMapping("/api/v1/questions/{questionId}/comments")
    public ResponseEntity<ApiResult> getAllForQuestions(
            @PathVariable
            long questionId
    ) {
        List<CommentResponse> commentResponse = commentService.getAllForQuestion(questionId);
        return ApiResult.Created("Done", commentResponse);
    }

    @GetMapping("/api/v1/solutions/{solutionId}/comments")
    public ResponseEntity<ApiResult> getAllForSolutions(
            @PathVariable
            long solutionId
    ) {
        List<CommentResponse> commentResponse = commentService.getAllForSolution(solutionId);
        return ApiResult.Created("Done", commentResponse);
    }

    @GetMapping("/api/v1/comments/{commentId}")
    public ResponseEntity<ApiResult> getCommentDetail(
            @PathVariable
            long commentId
    ) {
        CommentResponse commentResponse = commentService.getDetail(commentId);
        return ApiResult.Created("Done", commentResponse);
    }

    @PostMapping("/api/v1/questions/{questionId}/comments")
    public ResponseEntity<ApiResult> createForQuestions(
            @PathVariable
            long questionId,
            @RequestBody
            CommentRequest dto
    ) {
        CommentResponse commentResponse = commentService.createForQuestion(questionId, dto);
        return ApiResult.Created("Comment is created successfully", commentResponse);
    }

    @PostMapping("/api/v1/solutions/{solutionId}/comments")
    public ResponseEntity<ApiResult> createForSolutions(
            @PathVariable
            long solutionId,
            @RequestBody
            CommentRequest dto
    ) {
        CommentResponse commentResponse = commentService.createForSolution(solutionId, dto);
        return ApiResult.Created("Comment is created successfully", commentResponse);
    }

    @PatchMapping("/api/v1/comments/{commentId}")
    public ResponseEntity<ApiResult> edit(
            @PathVariable
            long commentId,
            @RequestBody
            CommentRequest dto
    ) throws IllegalAccessException {
        CommentResponse commentResponse = commentService.edit(commentId, dto);
        return ApiResult.Ok("Comment Updated Successfully", commentResponse);
    }

    @DeleteMapping("/api/v1/comments/{commentId}")
    public ResponseEntity<ApiResult> delete(
            @PathVariable
            long commentId
    ) throws IllegalAccessException {
        commentService.delete(commentId);
        return ApiResult.Created("Comment was deleted successfully");
    }

}
