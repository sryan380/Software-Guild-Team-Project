/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ATeam.FantasyFootballBlog.config;

import com.ATeam.FantasyFootballBlog.services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author Steve
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    
    @Autowired
    BlogService service;
    
    @Autowired
    public void configureGlobalInDb(AuthenticationManagerBuilder auth)throws Exception{
        auth.userDetailsService(service).passwordEncoder(bCryptPasswordEncoder());
    }
    
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .antMatchers("/admin").hasRole("ADMIN")
                .antMatchers("/", "/home").permitAll()
                .antMatchers("/articles").permitAll()
                .antMatchers("/article").permitAll()
                .antMatchers("/register").permitAll()
                .antMatchers("/deleteArt/{id}").hasRole("ADMIN")
                .antMatchers("/viewArt_**").permitAll()
                .antMatchers("/Mascot.jpg").permitAll()
                .antMatchers("/register?register_error=1").permitAll()
                .antMatchers("/css/**", "/js/**","/fonts/**").permitAll()
                .anyRequest().hasRole("USER")
                
                .and()
                
                .formLogin().loginPage("/login")
                
                .failureUrl("/login?login_error=1").permitAll()
                
                .and()
                
                .logout().logoutSuccessUrl("/").permitAll();
    }
}
