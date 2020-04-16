/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ATeam.FantasyFootballBlog.controller;

import com.ATeam.FantasyFootballBlog.models.Article;
import com.ATeam.FantasyFootballBlog.services.BlogService;
import com.ATeam.FantasyFootballBlog.services.NullArticleException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Steve
 */
@Controller
public class TagController {
    
    @Autowired
    BlogService service;
    
    @PostMapping("/search")
    public String searchTag(String tag, Model model) throws NullArticleException{
        tag = "#" + tag.toLowerCase();
        List<Article> allArticles = service.getAllArticles(tag);
        model.addAttribute("allArticles", allArticles);
        return "articles";
    }
}
