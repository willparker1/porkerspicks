package com.porkerspicks.rest;

import com.porkerspicks.domain.Post;
import com.porkerspicks.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "posts/v1", produces = "application/json")
public class PostRestController {

    private final PostService postService;

    public PostRestController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public List<Post> getAllPosts(Model model ) {
        return postService.getAllPosts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> getPost(@PathVariable Integer id  ) {
        Post savedPost = postService.findPost(id);
        HttpStatus httpStatus = HttpStatus.OK;
        if ( savedPost == null ) {
            httpStatus = HttpStatus.NOT_FOUND;
        }
        return new ResponseEntity<>( savedPost, httpStatus);
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Post addPost( @RequestBody Post post ) {
        return postService.savePost(post);
    }

    @PatchMapping(path="/{id}", consumes = "application/json")
    public Post patchPost( @PathVariable Integer id, @RequestBody Post post ) {
        Post existingPost = postService.findPost(id);
        existingPost.setTitle(post.getTitle());
        existingPost.setContent(post.getContent());
        return postService.savePost( existingPost );
    }

    @PutMapping(path="/{id}", consumes = "application/json")
    public Post updatePost( @PathVariable Integer id, @RequestBody Post post ) {
        return postService.savePost( post );
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code=HttpStatus.NO_CONTENT)
    public void deletePost( @PathVariable Integer id ) {
        postService.deletePost( id );
    }
}
