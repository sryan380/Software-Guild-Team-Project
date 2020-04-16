/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ATeam.FantasyFootballBlog.Repository;

import com.ATeam.FantasyFootballBlog.models.Article;
import com.ATeam.FantasyFootballBlog.models.Tag;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Steve
 */
@Repository
public interface TagRepository extends JpaRepository<Tag, Integer>{
    List<Tag> findByArticles(Article article);
    List<Tag> findByName(String name);
}
