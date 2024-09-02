package com.example.cybsec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.cybsec.entity.User;
import com.example.cybsec.service.UserService;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/logout")
    public String logout() {
        return "redirect:/login?logout";
    }

    @GetMapping("/register")
    public String register(
        @RequestParam String username, 
        @RequestParam String password,
        Model model
    ){
        if(userService.findByUsername(username) != null){
            model.addAttribute("error", "User already exists");
            return "register";
        }
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        userService.saveUser(user);
        return "redirect:/login";
    }
    
}
