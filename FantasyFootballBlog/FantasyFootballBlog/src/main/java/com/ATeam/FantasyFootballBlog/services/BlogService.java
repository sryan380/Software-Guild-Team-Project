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
import java.util.List;
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

    public Article editArticle(Article editArt) {
        Article edited = artRepo.save(editArt);
        return edited;
    }

    public void deleteArticle(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void contComment(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
     public Comment userComment(Comment comment) {
        Comment posted = commentRepo.save(comment);
        return posted;
    }

    public void createTag() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void createReport() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Article getArticleById(Integer id) {
        id = 1;
        Optional<Article> articles = artRepo.findById(id);
        Article toReturn = articles.get();
        return toReturn;
    }
    
    public Set<Role> convertListToSet(List<Role> list){ 
        return new HashSet<>(list); 
    } 

    public void createUser(User newUser) {
        List<Role> roles = roleRepo.findAll();
        Set<Role> setOfRoles = convertListToSet(roles);
        setOfRoles.remove(roles.get(0));
        newUser.setRoles(setOfRoles);
        userRepo.save(newUser);
    }
}
