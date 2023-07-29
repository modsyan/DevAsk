package com.trainning.springapp.controller;

import com.trainning.springapp.model.Post;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {

    @GetMapping()
    public ResponseEntity<List<Post>> GetAll() {
        List<Post> posts = new ArrayList<>();
        posts.add(new Post(1, 1, "this is title", "content", false, new Date(), new Date()));
        posts.add(new Post(2, 1, "this is title", "content", false, new Date(), new Date()));
        return ResponseEntity.ok(posts);
    }

    @GetMapping("/{id}")
    public Post GetDetail(@PathVariable int id) {
        return new Post(id, 1, "this is title", "content", false, new Date(), new Date());
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Post> Create(@RequestBody Post post) {
        return new ResponseEntity<Post>(post, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<Post> Edit(@RequestBody Post post, @PathVariable int id) {

        Post newPost = new Post(5, 5, "this is old title", "content", false, new Date(), new Date());

        newPost.setTitle(post.getTitle());
        newPost.setContent(post.getContent());
        newPost.setHasMedia(post.isHasMedia());
        newPost.setUpdatedAt(new Date());

        return new ResponseEntity<Post>(newPost, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Post>> Delete(@PathVariable int id) {
        List<Post> posts = new ArrayList<>();
        posts.add(new Post(0, 1, "this is title", "content", false, new Date(), new Date()));
        posts.add(new Post(1, 1, "this is title", "content", false, new Date(), new Date()));
        posts.add(new Post(2, 1, "this is title", "content", false, new Date(), new Date()));
        //by index
        posts.remove(id);
        System.out.println(posts);
        return new ResponseEntity<List<Post>>(posts, HttpStatus.OK);
    }

}
