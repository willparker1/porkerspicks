package com.porkerspicks.controller;

import com.porkerspicks.domain.Pick;
import com.porkerspicks.domain.Post;
import com.porkerspicks.service.PickService;
import com.porkerspicks.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("picks")
public class PickController {

    private final PickService pickService;

    public PickController(PickService pickService) {
        this.pickService = pickService;
    }

    @GetMapping("/create")
    public String createPick( Model model ) {
        model.addAttribute("pick", new Pick() );
        return "postForm";
    }

    @GetMapping("/edit/{id}")
    public String editPost( @PathVariable Integer id, Model model  ) {
        model.addAttribute("post", postService.findPost(id) );
        return "postForm";
    }

    @PostMapping
    public String savePost( Post post ) {
        postService.savePost(post);
        return "redirect:/posts";
    }

    @PostMapping("/update/{id}")
    public String updatePost( @PathVariable Integer id, Post post ) {
        Post existingPost = postService.findPost(id);
        existingPost.setTitle(post.getTitle());
        existingPost.setContent(post.getContent());
        postService.savePost( existingPost );
        return "redirect:/posts";
    }

    @GetMapping("/delete/{id}")
    public String deletePost( @PathVariable Integer id ) {
        postService.deletePost( id );
        return "redirect:/posts";
    }
}
