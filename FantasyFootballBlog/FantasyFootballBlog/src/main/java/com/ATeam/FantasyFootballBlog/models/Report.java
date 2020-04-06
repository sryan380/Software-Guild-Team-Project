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

    public int getReport_id() {
        return report_id;
    }

    public void setReport_id(int report_id) {
        this.report_id = report_id;
    }

    public String getUser_complaint() {
        return user_complaint;
    }

    public void setUser_complaint(String user_complaint) {
        this.user_complaint = user_complaint;
    }

    public User getUser_id() {
        return user_id;
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }

    public Article getArticle_id() {
        return article_id;
    }

    public void setArticle_id(Article article_id) {
        this.article_id = article_id;
    }

    public Comment getComment_id() {
        return comment_id;
    }

    public void setComment_id(Comment comment_id) {
        this.comment_id = comment_id;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + this.report_id;
        hash = 53 * hash + Objects.hashCode(this.user_complaint);
        hash = 53 * hash + Objects.hashCode(this.user_id);
        hash = 53 * hash + Objects.hashCode(this.article_id);
        hash = 53 * hash + Objects.hashCode(this.comment_id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Report other = (Report) obj;
        if (this.report_id != other.report_id) {
            return false;
        }
        if (!Objects.equals(this.user_complaint, other.user_complaint)) {
            return false;
        }
        if (!Objects.equals(this.user_id, other.user_id)) {
            return false;
        }
        if (!Objects.equals(this.article_id, other.article_id)) {
            return false;
        }
        if (!Objects.equals(this.comment_id, other.comment_id)) {
            return false;
        }
        return true;
    }
    
}
