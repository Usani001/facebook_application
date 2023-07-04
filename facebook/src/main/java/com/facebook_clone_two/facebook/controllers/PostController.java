package com.facebook_clone_two.facebook.controllers;

import com.facebook_clone_two.facebook.entities.AppUser;
import com.facebook_clone_two.facebook.entities.Post;
import com.facebook_clone_two.facebook.service.PostServices;
import com.facebook_clone_two.facebook.service.UserServices;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Controller
@RequestMapping(path = "/facebookClone")
public class PostController {
    private final PostServices postServices;

    @RequestMapping(method = RequestMethod.POST, path = "/post")
    public String createPost(@ModelAttribute("post")Post post, HttpSession session){
        AppUser user = (AppUser) session.getAttribute("AppUser");
        Post post1 = new Post();
        post1.setAppUser(user);
//        post1.setPostMessage(post);
            postServices.makePost(post);
            System.out.println(post.getPostMessage());
            return "homePage";

    }

    @GetMapping("/post")
    public String getPostPage(Model model){
        model.addAttribute ("post", new Post());
        return "homePage";
    }
    @PostMapping("/all-posts")
    public String getAllPosts(Post post, Model model) {
        model.addAttribute("posts",
                postServices.getAllPosts(post));
        return "homePage";
    }
    @GetMapping("/all-posts")
    public String viewAllPosts(Model model) {
        model.addAttribute("posts", new Post());
        return "homePage";

    }
}
