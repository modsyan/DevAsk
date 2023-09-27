package com.devAsk.api.controller;

import com.devAsk.api.enums.VoteType;
import com.devAsk.api.model.ApiResult;
import com.devAsk.api.service.VoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;

@RestController
@RequiredArgsConstructor
public class VoteController {

    private final VoteService voteService;

    @PostMapping("/api/questions/{question_id}/vote/up")
    public ResponseEntity<ApiResult> VoteUpQuestion(
            @PathVariable
            long question_id
    ) {
        return ApiResult.Ok("Vote up Question Added", voteService.question(question_id, VoteType.VOTE_UP));
    }

    @PostMapping("/api/questions/{question_id}/vote/down")
    public ResponseEntity<ApiResult> VoteDownQuestion(
            @PathVariable
            long question_id
    ) {
        return ApiResult.Ok("Vote Down Question Added", voteService.question(question_id, VoteType.VOTE_DOWN));
    }

    @PostMapping("/api/solution/{solution_id}/vote/up")
    public ResponseEntity<ApiResult> VoteUpSolution(
            @PathVariable
            long solution_id
    ) {
        return ApiResult.Ok("Vote Up Solution Added", voteService.question(solution_id, VoteType.VOTE_UP));
    }

    @PostMapping("/api/solution/{solution_id}/vote/down")
    public ResponseEntity<ApiResult> VoteDownSolution(
            @PathVariable
            long solution_id
    ) {
        return ApiResult.Ok("Vote Down Solution Added", voteService.question(solution_id, VoteType.VOTE_DOWN));
    }
}
