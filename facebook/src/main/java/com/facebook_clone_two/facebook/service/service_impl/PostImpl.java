package com.facebook_clone_two.facebook.service.service_impl;

import com.facebook_clone_two.facebook.entities.Post;
import com.facebook_clone_two.facebook.repository.PostRepository;
import com.facebook_clone_two.facebook.service.PostServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service



public class PostImpl implements PostServices {
    private final PostRepository postRepository;
    @Override
    public void makePost(Post post) {
     postRepository.save(post);
    }
    public List<Post> getAllPosts(Post post) {
        return postRepository.findAll();
    }

}
