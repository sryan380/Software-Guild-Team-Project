/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ATeam.FantasyFootballBlog.Repository;

import com.ATeam.FantasyFootballBlog.models.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author benvance
 */
@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer> {
    
}

