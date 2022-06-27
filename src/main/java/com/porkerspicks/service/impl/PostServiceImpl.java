package com.porkerspicks.service.impl;

import com.porkerspicks.domain.Post;
import com.porkerspicks.repository.PickRepository;
import com.porkerspicks.repository.PostRepository;
import com.porkerspicks.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Post savePost( Post post ) {
        return postRepository.save(post);
    }

    public Post findPost( Integer id ) {
        return postRepository.findById(id).get();
    }

    public void deletePost( Integer id ) {
         postRepository.deleteById(id);
    }
}
