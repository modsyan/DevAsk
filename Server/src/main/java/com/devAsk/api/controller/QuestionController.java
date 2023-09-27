package com.devAsk.api.controller;

import com.devAsk.api.dto.request.QuestionRequest;
import com.devAsk.api.dto.response.QuestionResponse;
import com.devAsk.api.enums.PaginationDefaults;
import com.devAsk.api.model.ApiResult;
import com.devAsk.api.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

//@CrossOrigin(origins = "http://localhost:5173")
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
    @GetMapping
    public ResponseEntity<ApiResult> GetAll(
            @RequestParam(
                    value = "page",
                    defaultValue = PaginationDefaults.DEFAULT_PAGE_NUMBER,
                    required = false
            )
            int page,
            @RequestParam(
                    value = "size",
                    defaultValue = PaginationDefaults.DEFAULT_PAGE_SIZE,
                    required = false
            )
            int size,
            @RequestParam(
                    value = "sortBy",
                    defaultValue = PaginationDefaults.DEFAULT_SORT_BY,
                    required = false
            )
            String sortBy,
            @RequestParam(
                    value = "sortDir",
                    defaultValue = PaginationDefaults.DEFAULT_SORT_DIRECTION,
                    required = false
            )
            String sortDir

    ) {
        Sort.Direction dir = Objects.equals(sortDir, "asc")
                ? Sort.Direction.ASC
                : Sort.Direction.DESC;

        Pageable pageable = PageRequest.of(page, size, Sort.by(dir, sortBy));
        return ApiResult.Ok("success", _questionService.getAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResult> GetDetail(
            @PathVariable
            long id
    ) {
        return ApiResult.Ok("success", _questionService.getDetails(id));
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ApiResult> Create(
            @RequestBody
            QuestionRequest dto
    ) {
        QuestionResponse createPost = _questionService.create(dto);
        return ApiResult.Created("Question Created Successfully", createPost);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<ApiResult> Edit(
            @PathVariable
            long id,
            @RequestBody
            QuestionRequest dto
    ) {
        return ApiResult.Ok("Response is edited", _questionService.edit(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResult> Delete(
            @PathVariable
            long id
    ) throws IllegalAccessException {
        _questionService.Delete(id);
        return ApiResult.Ok("Deleted Successfully");
    }
}
