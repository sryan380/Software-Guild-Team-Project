/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ATeam.FantasyFootballBlog.controller;

import com.ATeam.FantasyFootballBlog.models.Article;
import com.ATeam.FantasyFootballBlog.services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public String createArticle(Article newArt){
        newArt = service.createArticle(newArt);
        return "redirect:/static_" + newArt.getArticle_id();
    }
    
    @PostMapping("/editArt")
    public void editArticle(Article editArt){
        service.editArticle(editArt);
    }
    
    @PostMapping("/deleteArt")
    public void deleteArticle(Integer id){
        service.deleteArticle(id);
    }
        @PostMapping("/comment")
    public void contComment(Integer id){
        service.contComment(id);
    }
    
}
