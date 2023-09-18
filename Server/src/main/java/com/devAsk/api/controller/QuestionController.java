package com.devAsk.api.controller;

import com.devAsk.api.dto.request.CreateEditQuestionRequest;
import com.devAsk.api.dto.response.QuestionResponse;
import com.devAsk.api.model.ApiResult;
import com.devAsk.api.service.QuestionService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/questions")
//@PreAuthorize("hasRole('USER')")
@RequiredArgsConstructor
public class QuestionController {
    private final QuestionService _questionService;

    @GetMapping
    public ResponseEntity<List<QuestionResponse>> GetAll() {
        //        List<QuestionResponse> response = _questionService.GetAll();
        //        return new ResponseEntity<>(response, HttpStatus.OK);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public QuestionResponse GetDetail(
            @PathVariable
            long id
    ) {
        return _questionService.GetDetails(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<QuestionResponse> Create(
            @RequestBody
            CreateEditQuestionRequest dto
    ) {
        QuestionResponse createPost = _questionService.Create(dto);
        return new ResponseEntity<>(createPost, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<QuestionResponse> Edit(
            @PathVariable
            long id,
            @RequestBody
            CreateEditQuestionRequest dto
    ) {
        QuestionResponse updatedPost = _questionService.Edit(id, dto);
        return new ResponseEntity<>(updatedPost, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ApiResult> Delete(
            @PathVariable
            long id
    ) {
        _questionService.Delete(id);
        return ApiResult.Ok("Deleted Successfully");
    }

}
