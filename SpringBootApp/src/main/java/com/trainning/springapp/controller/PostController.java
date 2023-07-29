package com.trainning.springapp.controller;

import com.trainning.springapp.model.Post;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class PostController {

    @GetMapping("Post")
    public ResponseEntity<List<Post>> GetPosts() {
        List<Post> posts = new ArrayList<>();
        posts.add(new Post(1, 1, "this is title", "content", false, new Date(), new Date()));
        posts.add(new Post(2, 1, "this is title", "content", false, new Date(), new Date()));
        return ResponseEntity.ok(posts);
    }
}
