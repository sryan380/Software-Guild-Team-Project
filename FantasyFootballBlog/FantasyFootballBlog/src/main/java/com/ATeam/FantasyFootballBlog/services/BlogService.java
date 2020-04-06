/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ATeam.FantasyFootballBlog.services;

import com.ATeam.FantasyFootballBlog.Daos.UserDao;
import com.ATeam.FantasyFootballBlog.models.Role;
import com.ATeam.FantasyFootballBlog.models.User;
import java.util.HashSet;
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
    UserDao dao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User loaded = dao.getUserByUsername(username);
        
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

    public void createArticle() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void editArticle(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void deleteArticle(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void contComment(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void createTag() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void createReport() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
