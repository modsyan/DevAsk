package com.devAsk.api.controller;

import com.devAsk.api.dto.request.CreateEditQuestionRequest;
import com.devAsk.api.dto.response.QuestionResponse;
import com.devAsk.api.model.ApiResult;
import com.devAsk.api.service.QuestionService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
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

//    @GetMapping(params = {"page", "size"})
//    public ResponseEntity<ApiResult> GetAll(@RequestParam("page") int page, @RequestParam("size") int size, ) {
//        return ApiResult.Ok("success", _questionService.GetAll());
//    }

//    @GetMapping
    @GetMapping(params = {"page", "size"})
    public ResponseEntity<ApiResult> GetAll(
            @RequestParam("page")
            int page,
            @RequestParam("size")
            int size,
            @SortDefault(
                    sort = "createdAt",
                    direction = Sort.Direction.DESC
            )
            @PageableDefault(size = 5)
            final Pageable pageable
    ) {
        return ApiResult.Ok("success", _questionService.GetAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResult> GetDetail(
            @PathVariable
            long id
    ) {
        return ApiResult.Ok("success", _questionService.GetDetails(id));
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ApiResult> Create(
            @RequestBody
            CreateEditQuestionRequest dto
    ) {
        QuestionResponse createPost = _questionService.Create(dto);
        return ApiResult.Created("Question Created Successfully", createPost);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<ApiResult> Edit(
            @PathVariable
            long id,
            @RequestBody
            CreateEditQuestionRequest dto
    ) {
        return ApiResult.Ok("Response is edited", _questionService.Edit(id, dto));
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
