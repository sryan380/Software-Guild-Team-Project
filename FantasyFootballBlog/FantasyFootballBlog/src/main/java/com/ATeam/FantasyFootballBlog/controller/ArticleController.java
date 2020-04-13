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
import com.ATeam.FantasyFootballBlog.services.NullArticleException;
import com.ATeam.FantasyFootballBlog.services.NullCommentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Steve
 */
@Controller
public class ArticleController {
    
    @Autowired
    BlogService service;

    @GetMapping("/articles")
    public String displayContentPage() {
        return "articles";
    }

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
    public String getArticle(@PathVariable("id") Integer id, Model model) throws NullArticleException {
        Article toView = service.getArticleById(id);
        model.addAttribute("article", toView);
        return "article";
    }
    
    @PostMapping("/editArt")
    public void editArticle(Article editArt) throws NullArticleException {
        service.editArticle(editArt);
    }
    
//    @PostMapping("/deleteArt_{id}")
//    public String deleteArticle(@PathVariable Article id) {
//        service.deleteArticle(id);
//        return "/article";
//    }
    
//    @RequestMapping(value = "/deleteArt_/{article.article_id}", method = RequestMethod.GET)
//    public String deleteArticle(@PathVariable Article id) {
//        service.deleteArticle(id);
//    return "redirect:/article";
//}
    @RequestMapping("/deleteArt/{id}")
    public String deleteAticle(@PathVariable(name = "id") int id) {
        
        service.deleteArticle(id);
        return "redirect:/";
    }

    @PostMapping("/contComment")
    public void contComment(Integer id) {
        service.contComment(id);
    }

    @PostMapping("/comment")
    public String userComment(Comment comment) throws NullCommentException {
        
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
        
        return "redirect:/viewArt_" + comment.getArticle_id().getArticle_id();
    }

    

}
