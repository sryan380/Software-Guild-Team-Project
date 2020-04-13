/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ATeam.FantasyFootballBlog.DAOTest;

import com.ATeam.FantasyFootballBlog.Repository.ArticleRepository;
import com.ATeam.FantasyFootballBlog.models.Article;
import com.ATeam.FantasyFootballBlog.models.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

/**
 *
 * @author davidsteffes
 */
public class ArtRepoInMemDao implements ArticleRepository {

    List<Article> allArticles = new ArrayList<>();

    public ArtRepoInMemDao() {

        User testUser = new User();
        testUser.setId(5678);
        testUser.setEnabled(true);
        testUser.setUsername("Test Name");
        testUser.setPassword("Test password");
        //testUser.setRoles("test role");
        //Dave: want to see what a sample variable value is for Set<Role>

        Article testArt = new Article();
        testArt.setArticle_id(1234);
        testArt.setTitle("Test Name");
        testArt.setContent("Test Text");
        allArticles.add(testArt);

        User testUser2 = new User();
        testUser2.setId(100);
        testUser2.setEnabled(true);
        testUser2.setUsername("Bob");
        testUser2.setPassword("1234");
        //testUser.setRoles("test role");
        //Dave: want to see what a sample variable value is for Set<Role>

        Article testArt2 = new Article();
        testArt2.setTitle("Editorial");
        testArt2.setContent("Opinion");
        testArt2.setUser(testUser2);
        allArticles.add(testArt2);
        
    }

    @Override
    public Optional<Article> findById(Integer id) {
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

//        Article testArticle = allArticles.get(0);
//         return Optional    
        
    }

    @Override
    public List<Article> findAll() {
        return allArticles;
        }
    
    @Override
    public <S extends Article> S save(S s) {
        
        s.setArticle_id(allArticles.stream().mapToInt( a -> a.getArticle_id() ).max().orElse(0) + 1);
        
        allArticles.add(s);
        
        return s;
    }

    @Override
    public List<Article> findAll(Sort sort) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Article> findAllById(Iterable<Integer> itrbl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public <S extends Article> List<S> saveAll(Iterable<S> itrbl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void flush() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public <S extends Article> S saveAndFlush(S s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteInBatch(Iterable<Article> itrbl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteAllInBatch() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Article getOne(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public <S extends Article> List<S> findAll(Example<S> exmpl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public <S extends Article> List<S> findAll(Example<S> exmpl, Sort sort) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Page<Article> findAll(Pageable pgbl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean existsById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long count() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Article t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteAll(Iterable<? extends Article> itrbl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public <S extends Article> Optional<S> findOne(Example<S> exmpl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public <S extends Article> Page<S> findAll(Example<S> exmpl, Pageable pgbl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public <S extends Article> long count(Example<S> exmpl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public <S extends Article> boolean exists(Example<S> exmpl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
