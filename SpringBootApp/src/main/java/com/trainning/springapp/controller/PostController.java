package com.trainning.springapp.controller;

import com.trainning.springapp.dto.requset.CreateEditPostRequest;
import com.trainning.springapp.dto.response.PostResponse;
import com.trainning.springapp.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {
    private final PostService _postService;

    @Autowired
    public PostController(PostService postService) {
        _postService = postService;
    }

    @GetMapping()
    public ResponseEntity<List<PostResponse>> GetAll() {
        List<PostResponse> response = _postService.GetAll();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public PostResponse GetDetail(@PathVariable long id) {
        return _postService.GetDetails(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<PostResponse> Create(@RequestBody CreateEditPostRequest dto) {
        PostResponse createPost = _postService.Create(dto);
        return new ResponseEntity<>(createPost, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<PostResponse> Edit(@PathVariable long id, @RequestBody CreateEditPostRequest dto) {
        PostResponse updatedPost = _postService.Edit(id, dto);
        return new ResponseEntity<>(updatedPost, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> Delete(@PathVariable long id) {
        _postService.Delete(id);
        return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
    }

}
