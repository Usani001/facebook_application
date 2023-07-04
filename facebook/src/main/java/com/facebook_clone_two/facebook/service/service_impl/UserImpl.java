package com.facebook_clone_two.facebook.service.service_impl;

import com.facebook_clone_two.facebook.entities.AppUser;
import com.facebook_clone_two.facebook.repository.UserRepository;
import com.facebook_clone_two.facebook.service.UserServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
@RequiredArgsConstructor
@Service
public class UserImpl implements UserServices {
    private final UserRepository userRepository;

    @Override
    public void loginUser(String email, String password) {
        Optional<AppUser> userOptional = userRepository.findUserByEmail(email);
        if (userOptional.isEmpty()){
            throw new IllegalStateException("User does not exist!!! Please if you are new, Hit the signup button");
        }
        AppUser appUser = userOptional.get();
        if (!appUser.getPassword().equals(password)) {
            throw new IllegalArgumentException("Invalid password!!! Please put a valid password");
        }
    }

    @Override
    public void addNewUser(AppUser appUser) {
        Optional<AppUser> appUserOptional = userRepository.findUserByEmail(appUser.getEmail());
        if (appUserOptional.isPresent()){
            throw new IllegalStateException("email has been is used by another account");
        }
        userRepository.save(appUser);
    }

    @Override
    public void deleteUser(Long id) {

    }
}
