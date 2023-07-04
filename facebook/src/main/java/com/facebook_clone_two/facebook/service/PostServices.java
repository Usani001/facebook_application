package com.facebook_clone_two.facebook.service;

import com.facebook_clone_two.facebook.entities.Post;

import java.util.List;

public interface PostServices {
    void makePost(Post post);
    List<Post> getAllPosts(Post post);
}
