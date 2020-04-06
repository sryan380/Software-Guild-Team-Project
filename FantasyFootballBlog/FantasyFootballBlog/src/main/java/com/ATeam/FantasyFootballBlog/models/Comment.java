/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ATeam.FantasyFootballBlog.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Steve
 */
@Entity
public class Comment {
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int comment_id;
    
    @Column(nullable = false)
    private String content;
    
    @ManyToOne
    @JoinColumn(name = "article_id", nullable = false)
    private Article article_id;
    
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user_id;
}
