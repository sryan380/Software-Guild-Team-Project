/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ATeam.FantasyFootballBlog.services;

import com.ATeam.FantasyFootballBlog.Daos.UserDao;
import com.ATeam.FantasyFootballBlog.Repository.ArticleRepository;
import com.ATeam.FantasyFootballBlog.Repository.CommentRepository;
import com.ATeam.FantasyFootballBlog.Repository.RoleRepository;
import com.ATeam.FantasyFootballBlog.Repository.UserRepository;
import com.ATeam.FantasyFootballBlog.models.Article;
import com.ATeam.FantasyFootballBlog.models.Comment;
import com.ATeam.FantasyFootballBlog.models.Role;
import com.ATeam.FantasyFootballBlog.models.User;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author Steve
 */
@Service
public class BlogService implements UserDetailsService{
    
    @Autowired
    UserDao userDao;
    
    @Autowired
    ArticleRepository artRepo;
    
    @Autowired
    UserRepository userRepo;
    
    @Autowired
    RoleRepository roleRepo;
    
    @Autowired
    CommentRepository commentRepo;
    
    @Autowired
        public BlogService (UserDao userDao, ArticleRepository artRepo, CommentRepository commentRepo){
            this.userDao = userDao;
            this.artRepo = artRepo;
            this.commentRepo = commentRepo;
        }
    
    

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User loaded = userDao.getUserByUsername(username);
        
        if (loaded == null){
            throw new UsernameNotFoundException("could not find user name: " + username);
        }
        
        Set<GrantedAuthority> userAuthorities = new HashSet<>();
        for(Role toConvert : loaded.getRoles()) {
            userAuthorities.add(new SimpleGrantedAuthority(toConvert.getRole()));
        }
        
        return new org.springframework.security.core.userdetails.User(
                loaded.getUsername(), 
                loaded.getPassword(), 
                userAuthorities);
        
    }
    
    public User getIdbyName(String name){
        User toReturn  = userDao.getUserByUsername(name);
        return toReturn;
    }
    
    public Article createArticle(Article newArt) {
        Article posted = artRepo.save(newArt);
        return posted;
    }

    public Article editArticle(Article editArt) throws NullArticleException {
        
        if( editArt == null){
            throw new NullArticleException("Null article in editArticle method.");
        }
        
        Article edited = artRepo.save(editArt);
        return edited;
    }

    public void deleteArticle(Article deleteArt) {
     //artRepo.delete(deleteArt.getArticle_id();
    }

    public void contComment(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
     public Comment userComment(Comment comment) throws NullCommentException {
        if (comment == null){
            throw new NullCommentException ("Got NullCommentException in userComment method.");
        }
        Comment posted = commentRepo.save(comment);
        return posted;
    }

    public void createTag() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void createReport() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Article getArticleById(Integer id) throws NullArticleException {
        id = 1;
        Optional<Article> articles = artRepo.findById(id);
        
        if(articles == null){
            throw new NullArticleException("Got null article in getArticleById.");
        }
        
        Article toReturn = articles.get();
        return toReturn;
    }

   
    
}
