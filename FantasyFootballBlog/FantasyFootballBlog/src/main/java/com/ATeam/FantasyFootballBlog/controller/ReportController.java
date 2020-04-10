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
 * @author davidsteffes
 */
@Controller
public class ReportController {
    
    @Autowired
    BlogService service;
    
    @PostMapping("/report")
    public void createReport(){
        service.createReport();
    }
    
}
