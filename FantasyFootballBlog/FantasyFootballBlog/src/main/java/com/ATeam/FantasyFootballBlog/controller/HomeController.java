/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ATeam.FantasyFootballBlog.controller;

import com.ATeam.FantasyFootballBlog.models.Article;
import com.ATeam.FantasyFootballBlog.models.User;
import com.ATeam.FantasyFootballBlog.services.BlogService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Steve
 */
@Controller
public class HomeController {
    
    @Autowired
    BlogService service;
    
    @GetMapping({"/", "/articles"})
    public String displayHomePage(Model model) {
        List<Article> articles = service.getAllArticles();
        model.addAttribute("allArticles", articles);
        return "articles";
    }
    
    @GetMapping("/createArt")
    public String displayStaticPage() {
        return "createArt";
    }
    
    @GetMapping("/register")
    public String displayRegisterPage(){
        return "register";
    }
}
