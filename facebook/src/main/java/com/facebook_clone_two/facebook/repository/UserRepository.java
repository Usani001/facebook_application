package com.facebook_clone_two.facebook.repository;

import com.facebook_clone_two.facebook.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<AppUser, Long> {

    Optional<AppUser> findUserByEmail(String email);



}
