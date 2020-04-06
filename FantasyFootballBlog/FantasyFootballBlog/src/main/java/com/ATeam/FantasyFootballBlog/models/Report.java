/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ATeam.FantasyFootballBlog.models;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Buddy
 */
@Entity
public class Report {
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int report_id;
    
    @Column(nullable = false)
    private String user_complaint;
    
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user_id;
    
    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article_id;
    
    @ManyToOne
    @JoinColumn(name = "comment_id")
    private Comment comment_id;
    
    
}
