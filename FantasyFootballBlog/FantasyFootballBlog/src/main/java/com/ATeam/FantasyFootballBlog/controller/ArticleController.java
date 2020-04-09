/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ATeam.FantasyFootballBlog.controller;

import com.ATeam.FantasyFootballBlog.models.Article;
import com.ATeam.FantasyFootballBlog.models.User;
import com.ATeam.FantasyFootballBlog.services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Steve
 */
@Controller
public class ArticleController {

    @GetMapping("/articles")
    public String displayContentPage() {
        return "articles";
    }

    @Autowired
    BlogService service;

    @PostMapping("/postArt")
    public String createArticle(Article newArt) {

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }

        User author = service.getIdbyName(username);
        newArt.setUser(author);
        service.createArticle(newArt);
        return "redirect:/";
    }

    // finish later
    @GetMapping("/viewArt")
    public String viewArticle(Integer id) {
        Article toView = service.getArticleById(id);

        return "something";
    }

//    @GetMapping("test")
//    public String testPage(Model model) {
//        String name = "John";
//        model.addAttribute("number", 42);
//        model.addAttribute("firstName", name);
//        return "test";
//    }

    @PostMapping("/editArt")
    public void editArticle(Article editArt) {
        service.editArticle(editArt);
    }

    @PostMapping("/deleteArt")
    public void deleteArticle(Integer id) {
        service.deleteArticle(id);
    }

    @PostMapping("/comment")
    public void contComment(Integer id) {
        service.contComment(id);
    }

}
