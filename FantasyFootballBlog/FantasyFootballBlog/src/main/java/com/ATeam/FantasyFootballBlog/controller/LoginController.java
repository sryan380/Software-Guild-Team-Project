/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ATeam.FantasyFootballBlog.controller;

import com.ATeam.FantasyFootballBlog.models.registerUser;
import com.ATeam.FantasyFootballBlog.services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Steve
 */
@Controller
public class LoginController {
    
    @Autowired
    BlogService service;
    
    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }
    
    @PostMapping("/register")
    public String registerUser(registerUser newUser){
        if (!newUser.getPassword().equals(newUser.getConfirmedPassword())){
            return "redirect:/register?register_error=1";
        }
        String hasedPass = passwordHash(newUser.getPassword());
        newUser.setPassword(hasedPass);
        service.createUser(newUser);
        return "login";
    }
    
    private String passwordHash(String userPassword) {
        
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        
        String hashedPassword = encoder.encode(userPassword);
        
        return hashedPassword;
    }
}
