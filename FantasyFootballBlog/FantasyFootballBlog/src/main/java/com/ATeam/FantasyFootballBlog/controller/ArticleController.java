/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ATeam.FantasyFootballBlog.controller;

import com.ATeam.FantasyFootballBlog.models.Article;
import com.ATeam.FantasyFootballBlog.models.Comment;
import com.ATeam.FantasyFootballBlog.models.User;
import com.ATeam.FantasyFootballBlog.services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @GetMapping("/viewArt_{id}")
    public String getArticle(@PathVariable("id") Integer id, Model model) {
        Article toView = service.getArticleById(id);
        model.addAttribute("article", toView.getContent());
        return "article";
    }
    
    @PostMapping("/editArt")
    public void editArticle(Article editArt) {
        service.editArticle(editArt);
    }

    @PostMapping("/deleteArt")
    public void deleteArticle(Article deleteArt) {
        service.deleteArticle(deleteArt);
    }

    @PostMapping("/contComment")
    public void contComment(Integer id) {
        service.contComment(id);
    }

    @PostMapping("/comment")
    public String userComment(Comment comment) {
        
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }
        
        User author = service.getIdbyName(username);
        comment.setUser(author);
        service.userComment(comment);
        
        return "redirect:/";
    }

    

}
