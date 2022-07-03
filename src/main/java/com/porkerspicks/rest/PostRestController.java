package com.porkerspicks.rest;

import com.porkerspicks.domain.Post;
import com.porkerspicks.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("posts/v1")
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
    public Post editPost( @PathVariable Integer id, Model model  ) {
        return postService.findPost(id);
    }

    @PostMapping
    public Post savePost( Post post ) {
        return postService.savePost(post);
    }

    @PatchMapping("/{id}")
    public Post patchPost( @PathVariable Integer id, Post post ) {
        Post existingPost = postService.findPost(id);
        existingPost.setTitle(post.getTitle());
        existingPost.setContent(post.getContent());
        return postService.savePost( existingPost );
    }

    @PutMapping("/{id}")
    public Post updatePost( @PathVariable Integer id, Post post ) {
        return postService.savePost( post );
    }

    @DeleteMapping("/{id}")
    public String editPost( @PathVariable Integer id ) {
        postService.deletePost( id );
        return "redirect:/posts";
    }
}
