package com.facebook_clone_two.facebook.repository;

import com.facebook_clone_two.facebook.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {

    Optional<Post> getFirstByPostMessage(String postMessage);
}
