package com.facebook_clone_two.facebook.service;

import com.facebook_clone_two.facebook.entities.AppUser;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserServices {

    void loginUser(String email, String password);
    void addNewUser(AppUser appUser);

    void deleteUser(Long id);
}
