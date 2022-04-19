package com.porkerspicks.controller;

import com.porkerspicks.domain.Post;
import com.porkerspicks.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/posts")
    public String getAllPosts( Model model ) {
        model.addAttribute("posts", postService.getAllPosts() );
        return "posts";
    }

    @GetMapping("/posts/create")
    public String createPost( Model model ) {
        model.addAttribute("post", new Post() );
        return "postForm";
    }

    @PostMapping("/posts")
    public String savePost( Post post ) {
        postService.savePost(post);
        return "redirect:/posts";
    }

    @GetMapping("/posts/{id}")
    public String updatePost( @PathVariable Integer id, Post post ) {
        Post existingPost = postService.findPost(id);
        existingPost.setTitle(post.getTitle());
        existingPost.setContent(post.getContent());
        postService.savePost( existingPost );
        return "redirect:/posts";
    }
}
