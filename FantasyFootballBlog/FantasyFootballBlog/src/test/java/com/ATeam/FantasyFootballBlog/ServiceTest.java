/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ATeam.FantasyFootballBlog;

import com.ATeam.FantasyFootballBlog.DAOTest.ArtRepoInMemDao;
import com.ATeam.FantasyFootballBlog.DAOTest.CommentRepoInMemDao;
import com.ATeam.FantasyFootballBlog.DAOTest.UserInMemDao;
import com.ATeam.FantasyFootballBlog.Daos.UserDao;
import com.ATeam.FantasyFootballBlog.Repository.ArticleRepository;
import com.ATeam.FantasyFootballBlog.Repository.CommentRepository;
import com.ATeam.FantasyFootballBlog.models.Article;
import com.ATeam.FantasyFootballBlog.models.Comment;
import com.ATeam.FantasyFootballBlog.models.User;
import com.ATeam.FantasyFootballBlog.services.BlogService;
import com.ATeam.FantasyFootballBlog.services.NullArticleException;
import com.ATeam.FantasyFootballBlog.services.NullCommentException;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;

/**
 *
 * @author davidsteffes
 */
public class ServiceTest {
//
//    UserDao userDaoTest = new UserInMemDao();
//    ArticleRepository artRepoTest = new ArtRepoInMemDao();
//    CommentRepository commentRepoTest = new CommentRepoInMemDao();
//
//    BlogService serviceTest = new BlogService(userDaoTest, artRepoTest, commentRepoTest);
//
////    public void loadUserByUsernameGoldenPath (){
////        try{
////           String validation;
////           User testUser = serviceTest.loadUserByUsername(validation);
////        }
////    }
//    @Test
//    public void testEditArticleGoldenPath() {
//
//        try {
//
//            List<Article> testList = artRepoTest.findAll();
//            Article testArticle = testList.get(0);
//            Article validation = serviceTest.editArticle(testArticle);
//            User testUser = validation.getUser();
//
//            assertEquals(1234, validation.getArticle_id());
//            assertEquals("Test Name", validation.getTitle());
//            assertEquals("Test Text", validation.getContent());
//            assertEquals(5678, testUser.getId());
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
//
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
//
//    @Test
//    public void testUserCommentNullComment() {
//        try {
//            Comment validation = serviceTest.userComment(null);
//
//        } catch (NullCommentException ex) {
//        }
//    }
//
//    @Test
//    public void getArticleById() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//
//    }
//
}
