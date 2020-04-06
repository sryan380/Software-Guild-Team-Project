/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ATeam.FantasyFootballBlog.controller;

import com.ATeam.FantasyFootballBlog.services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author benvance
 */
@Controller
public class ArticleController {
    
    @Autowired
    BlogService service;
    
    @PostMapping("/postArt")
    public void createArticle(){
        service.createArticle();
    }
    
    @PostMapping("/editArt")
    public void editArticle(Integer id){
        service.editArticle(id);
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
