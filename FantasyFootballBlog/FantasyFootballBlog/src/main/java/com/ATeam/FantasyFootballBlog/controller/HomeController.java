/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ATeam.FantasyFootballBlog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Steve
 */
@Controller
public class HomeController {
    
    @GetMapping({"/", "/home"})
    public String displayHomePage() {
        
        return "home";
    }
    
}
