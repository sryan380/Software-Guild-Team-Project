/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ATeam.FantasyFootballBlog;

import com.ATeam.FantasyFootballBlog.DAOTest.ArtRepoInMemDao;
import com.ATeam.FantasyFootballBlog.DAOTest.CommentRepoInMemDao;
import com.ATeam.FantasyFootballBlog.DAOTest.RoleInMemDao;
import com.ATeam.FantasyFootballBlog.DAOTest.UserInMemDao;
import com.ATeam.FantasyFootballBlog.Daos.RoleDao;
import com.ATeam.FantasyFootballBlog.Daos.UserDao;
import com.ATeam.FantasyFootballBlog.Repository.ArticleRepository;
import com.ATeam.FantasyFootballBlog.Repository.CommentRepository;
import com.ATeam.FantasyFootballBlog.Repository.RoleRepository;
import com.ATeam.FantasyFootballBlog.models.Article;
import com.ATeam.FantasyFootballBlog.models.Comment;
import com.ATeam.FantasyFootballBlog.models.Role;
import com.ATeam.FantasyFootballBlog.models.User;
import com.ATeam.FantasyFootballBlog.services.BlogService;
import com.ATeam.FantasyFootballBlog.services.NullArticleException;
import com.ATeam.FantasyFootballBlog.services.NullCommentException;
import com.ATeam.FantasyFootballBlog.services.NullNameException;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;

/**
 *
 * @author davidsteffes
 */
public class ServiceTest {

    UserDao userDaoTest = new UserInMemDao();
    ArticleRepository artRepoTest = new ArtRepoInMemDao();
    CommentRepository commentRepoTest = new CommentRepoInMemDao();
    RoleRepository roleRepoTest = new RoleInMemDao();

    BlogService serviceTest = new BlogService(userDaoTest, artRepoTest, commentRepoTest);

    //public void loadUserByUsernameGoldenPath (){
//        
//    Smelser: You don't need to test this.
          
            
//    @Test
//    public void testGetIdByNameGoldenPath() {
//        try {
//            User testUser = serviceTest.getIdbyName("breadmania");
//
//            assertEquals(1234, testUser.getId());
//            assertEquals(true, testUser.isEnabled());
//            assertEquals("breadman", testUser.getPassword());
//            assertEquals("breadmania", testUser.getUsername());
//
//        } catch (NullNameException ex) {
//            fail("Got NullNameException during testGetIdbyNameGoldenPath");
//        }
//
//    }

    @Test
    public void testGetIdByNameNullName() {
        try {
            User testUser = serviceTest.getIdbyName(null);

        } catch (NullNameException ex) {

        }
    }

    @Test
    public void testCreateArticleGoldenPath() {
        try {
        List<Article> listOfArticles = artRepoTest.findAll();
        Article testArticle = listOfArticles.get(1);
        Article validation = serviceTest.createArticle(testArticle);
        
        assertEquals("Editorial", validation.getTitle());
        assertEquals("Opinion", validation.getContent());
        
        } catch (NullArticleException ex){
            fail("Got NullArticleException during testCreateArticleGoldenPath.");  
        }

    }
    
    @Test
    public void testCreateArticleNullArticle(){
        try{
            serviceTest.createArticle(null);
        } catch (NullArticleException ex){
        }
    }
    
//    @Test
//    public void testEditArticleGoldenPath() {
//
//        try {
//
//            List<Article> testList = artRepoTest.findAll();
//            Article testArticle = testList.get(0);
//            Article validation = serviceTest.editArticle(testArticle);
//            User testUser = validation.getUser();

            //not going to test validation.getArticle_id()) because
            //our save method in ArtRepoInMemDao outputs an ID
            //of 1 higher than the current-highest ID
//            assertEquals("Test Name", validation.getTitle());
//            assertEquals("Test Text", validation.getContent());
//            //assertEquals(5678, testUser.getId());
//            assertEquals(true, testUser.isEnabled());
//            assertEquals("Test Name", testUser.getUsername());
//            assertEquals("Test password", testUser.getPassword());
//            //assertEquals - need to use for testUser.setRoles("test role");
//
//        } catch (NullArticleException ex) {
//            fail("Got NullArticleException during testEditArticleGoldenPath");
//        }
//    }
//
//    @Test
//    public void testEditArticleNullArticle() {
//        try {
//
//            Article validation = serviceTest.editArticle(null);
//
//        } catch (NullArticleException ex) {
//        }
//
//    }

//    @Test
//    public void testUserCommentGoldenPath() {
//        try {
//            List<Article> testList = artRepoTest.findAll();
//            Article testArticle = testList.get(0);
//
//            List<Comment> commentList = commentRepoTest.findAll();
//            Comment testComment = commentList.get(0);
//
//            Comment validation = serviceTest.userComment(testComment);
//
//            assertEquals(1234, validation.getComment_id());
//            assertEquals("Test Content", validation.getContent());
//
//            assertEquals(1234, testArticle.getArticle_id());
//            assertEquals("Test Name", testArticle.getTitle());
//            assertEquals("Test Text", testArticle.getContent());
//
//            User testUser = testArticle.getUser();
//
//            assertEquals(5678, testUser.getId());
//            assertEquals(true, testUser.isEnabled());
//            assertEquals("Test Name", testUser.getUsername());
//            assertEquals("Test password", testUser.getPassword());
//            //assertEquals - need to use for testUser.setRoles("test role");
//        } catch (NullCommentException ex) {
//            fail("Hit NullCommentException during testUserCommentGoldenPath.");
//        }
//    }

    @Test
    public void testUserCommentNullComment() {
        try {
            Comment validation = serviceTest.userComment(null);

        } catch (NullCommentException ex) {
        }
    }

//    @Test
//    public void testGetArticleByIdGoldenPath() {
//        try{
//            
//        List<Article> articleList = artRepoTest.findAll();
//        Article testArticle = articleList.get(0);
//        Article validation = serviceTest.getArticleById(testArticle.getArticle_id());
//        
//        assertEquals(1234, validation.getArticle_id());
//        assertEquals("Test Name", validation.getTitle());
//        assertEquals("Test Text", validation.getContent());
//        
//        } catch (NullArticleException ex){
//            fail("Got NullArticleException during testGetArticleByIdGoldenPath.");
//        }
//        
//    }
    
//    @Test
//    public void testGetArticleByIdNullArticle () {
//        try{
//            Article validation = serviceTest.getArticleById(null);
//        
//        } catch (NullArticleException ex){
//        }
//        
//    }
    @Test
    public void testCreateUserGoldenPath (){
        
//        
//        
//        serviceTest.createUser(regUser);
//        
//        assertEquals();
//        
//        
        
        
        
        
    }
}
