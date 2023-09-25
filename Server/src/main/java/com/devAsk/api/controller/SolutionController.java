package com.devAsk.api.controller;

import com.devAsk.api.dto.request.SolutionRequest;
import com.devAsk.api.model.ApiResult;
import com.devAsk.api.service.SolutionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/solutions")
public class SolutionController {
    private final SolutionService solutionService;

    @GetMapping("~/api/v1/questions/{questionId}/solutions")
    public ResponseEntity<ApiResult> getAllFromQuestion(
            @PathVariable
            long questionId
    ) {
        return ApiResult.Ok("Success", solutionService.getAllFromQuestion(questionId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResult> getDetail(
            @PathVariable
            long id
    ) {
        return ApiResult.Ok("Success", solutionService.getDetail(id));
    }

    @PostMapping
    public ResponseEntity<ApiResult> create(
            @RequestBody
            SolutionRequest dto
    ) {
        return ApiResult.Created("Solution added successfully", solutionService.create(dto));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ApiResult> edit(
            @PathVariable
            long id,
            @RequestBody
            SolutionRequest dto
    ) throws IllegalAccessException {
        return ApiResult.Ok("Solution is updated", solutionService.edit(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResult> delete(
            @PathVariable
            long id
    ) throws IllegalAccessException {
        solutionService.delete(id);
        return ApiResult.Ok("Deleted Successfully");
    }

}
