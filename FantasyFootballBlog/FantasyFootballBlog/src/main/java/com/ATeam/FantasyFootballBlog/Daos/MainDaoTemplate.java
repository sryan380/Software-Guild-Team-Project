/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ATeam.FantasyFootballBlog.Daos;

import com.ATeam.FantasyFootballBlog.models.Article;
import com.ATeam.FantasyFootballBlog.models.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Steve
 */
@Repository
public class MainDaoTemplate implements MainDao{
    
    @Autowired
    JdbcTemplate template;
    
    @Override
    public void updateArt(Article newArt) {
        
        template.update("update articles Set content = ?, title = ? where article_id = ?", 
                        newArt.getContent(), newArt.getTitle(), newArt.getArticle_id());

    }
    
}
