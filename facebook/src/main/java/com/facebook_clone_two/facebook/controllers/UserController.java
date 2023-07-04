package com.facebook_clone_two.facebook.controllers;
import com.facebook_clone_two.facebook.entities.AppUser;
import com.facebook_clone_two.facebook.service.UserServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Controller
@RequestMapping(path = "/facebookClone")
public class UserController {
    private final UserServices userServices;

    @RequestMapping(method = RequestMethod.POST, path = "/signup")
    public String registerNewUser(@ModelAttribute("appUser") AppUser appUser, Model model){

        try {
            userServices.addNewUser(appUser);
            System.out.println(appUser);
            return "loginPage";
        } catch (Exception e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "registrationPage";
        }
//
    }

    @GetMapping("/signup")
    public String getUser(Model model){
        model.addAttribute ("appUser", new AppUser());
        return "registrationPage";
    }



    @RequestMapping(method = RequestMethod.POST, path = "/login")
    public String login(@ModelAttribute("appUser") AppUser appUser, Model model){
        try {
            userServices.loginUser(appUser.getEmail(), appUser.getPassword());
            System.out.println(appUser);
            return "homePage";
        } catch (Exception e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "loginPage";
        }
//
    }


    @GetMapping(path = "/login")
    public String loginUser(Model model){
        model.getAttribute("appUser");
        return "loginPage";
    }





    @DeleteMapping(path = "{appUserId}")
    public void deleteUser(@PathVariable("appUserId") Long id){
    userServices.deleteUser(id);
    }
}
