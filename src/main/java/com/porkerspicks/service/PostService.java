package com.porkerspicks.service;

import com.porkerspicks.domain.Post;

import java.util.List;
import java.util.Optional;

public interface PostService {

    public List<Post> getAllPosts();

    public Post savePost( Post post );

    public Post findPost(Integer id );

    public void deletePost( Integer id );
}
