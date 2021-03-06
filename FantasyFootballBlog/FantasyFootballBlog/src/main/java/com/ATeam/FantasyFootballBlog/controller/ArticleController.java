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
import com.ATeam.FantasyFootballBlog.services.NullNameException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Steve
 */
@Controller
public class ArticleController {

    @Autowired
    BlogService service;

    @PostMapping("/postArt")
    public String createArticle(Article newArt) throws NullArticleException, NullNameException {
        
        Article oldArt = service.getArticleById(newArt.getArticle_id());
        
        ArrayList<String> tags = new ArrayList<String>();
        String[] words = newArt.getContent().toLowerCase().split(",| |&|;|\\.|\\?|!|:|/|>|<");
        for (String word : words) {
            if (word.startsWith("#")) {
                tags.add(word);
            }
        }
        
        if(oldArt != null){
            service.updateArt(newArt);
            service.addTags(tags, newArt.getArticle_id());
            return "redirect:/";
        }

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
        service.addTags(tags, newArt.getArticle_id());
        return "redirect:/";
    }

    @GetMapping("/viewArt_{id}")
    public String getArticle(@PathVariable("id") Integer id, Model model) throws NullArticleException {
        Article toView = service.getArticleById(id);
        model.addAttribute("article", toView);
        return "article";
    }
    
    @RequestMapping("/editArt/{id}")
    public String editArticle(@PathVariable(name = "id") Integer id, Model model) throws NullArticleException {
        Article toView = service.getArticleById(id);
        model.addAttribute("toEdit", toView);
        return "editArticle";
    }
    
    @RequestMapping("/deleteArt/{id}")
    public String deleteAticle(@PathVariable(name = "id") Integer id) {

        service.deleteArticle(id);
        return "redirect:/";
    }

    @PostMapping("/contComment")
    public void contComment(Integer id) {
        service.contComment(id);
    }

    @PostMapping("/comment")
    public String userComment(Comment comment) throws NullCommentException, NullNameException {

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
