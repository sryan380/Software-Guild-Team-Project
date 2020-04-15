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
import com.ATeam.FantasyFootballBlog.Repository.TagRepository;
import com.ATeam.FantasyFootballBlog.Repository.UserRepository;
import com.ATeam.FantasyFootballBlog.models.Article;
import com.ATeam.FantasyFootballBlog.models.Comment;
import com.ATeam.FantasyFootballBlog.models.Role;
import com.ATeam.FantasyFootballBlog.models.Tag;
import com.ATeam.FantasyFootballBlog.models.User;
import java.util.ArrayList;
import com.ATeam.FantasyFootballBlog.models.RegisterUser;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.Collections;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.WebContext;

/**
 *
 * @author Steve
 */
@Service
public class BlogService implements UserDetailsService {

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
    TagRepository tagRepo;

    @Autowired
    public BlogService(UserDao userDao, ArticleRepository artRepo, CommentRepository commentRepo) {
        this.userDao = userDao;
        this.artRepo = artRepo;
        this.commentRepo = commentRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User loaded = userDao.getUserByUsername(username);

        if (loaded == null) {
            throw new UsernameNotFoundException("could not find user name: " + username);
        }

        Set<GrantedAuthority> userAuthorities = new HashSet<>();
        for (Role toConvert : loaded.getRoles()) {
            userAuthorities.add(new SimpleGrantedAuthority(toConvert.getRole()));
        }

        return new org.springframework.security.core.userdetails.User(
                loaded.getUsername(),
                loaded.getPassword(),
                userAuthorities);

    }

    public User getIdbyName(String name) throws NullNameException {

        if (name == null) {
            throw new NullNameException("Null name in getIdbyName method.");
        }

        User toReturn = userDao.getUserByUsername(name);
        return toReturn;
    }

    public Article createArticle(Article newArt) throws NullArticleException {

        if (newArt == null) {
            throw new NullArticleException("Null article during createArticle method.");
        }

        Article posted = artRepo.save(newArt);
        return posted;
    }

    public Article editArticle(Article editArt) throws NullArticleException {

        if (editArt == null) {
            throw new NullArticleException("Null article in editArticle method.");
        }

        Article edited = artRepo.save(editArt);
        return edited;
    }

    public void deleteArticle(int id) {

        artRepo.deleteById(id);

    }

    public void contComment(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Comment userComment(Comment comment) throws NullCommentException {
        if (comment == null) {
            throw new NullCommentException("Got NullCommentException in userComment method.");
        }
        Comment posted = commentRepo.save(comment);
        return posted;
    }

    public void createReport() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Article getArticleById(Integer id) throws NullArticleException {
        Optional<Article> articles = artRepo.findById(id);

        if (articles == null) {
            throw new NullArticleException("Got null article in getArticleById.");
        }

        Article toReturn = articles.get();
        return toReturn;
    }

    public Set<Role> convertListToSet(List<Role> list) {
        return new HashSet<>(list);
    }

    public void createUser(RegisterUser regUser) throws DuplicateEmailException {
        if (!emailUnique(regUser.getEmail())) {
            throw new DuplicateEmailException("Email is already resgistered");
        }
        List<Role> roles = roleRepo.findAll();
        Set<Role> setOfRoles = convertListToSet(roles);
        setOfRoles.remove(roles.get(0));
        setOfRoles.remove(roles.get(2));
        User newUser = new User();
        newUser.setUsername(regUser.getUsername());
        newUser.setFirst_name(regUser.getFirst_name());
        newUser.setLast_name(regUser.getLast_name());
        newUser.setPassword(regUser.getPassword());
        newUser.setPhone(regUser.getPhone());
        newUser.setRoles(setOfRoles);
        newUser.setEmail(regUser.getEmail());
        newUser.setEnabled(true);

        userRepo.save(newUser);
    }

    public void addTags(ArrayList<String> tags, Integer id) {
        Optional<Article> optArticles = artRepo.findById(id);
        Set<Article> articles = optArticles.map(Collections::singleton).orElse(Collections.emptySet());
        tags.removeIf(t
                -> t.equals("#333333") || t.equals("#ffffff") || t.equals("#"));
        for (String tag : tags) {
            List<Tag> matchingTags = tagRepo.findByName(tag);
            Tag currentTag = null;
            if (matchingTags.isEmpty()) {
                currentTag = new Tag();
                currentTag.setArticles(articles);
                currentTag.setName(tag);
                tagRepo.save(currentTag);
            } else {
                currentTag = matchingTags.get(0);
            }
            currentTag.getArticles().add(optArticles.get());
            tagRepo.save(currentTag);
        }

    }

    private boolean emailUnique(String email) {
        boolean isUnique = true;
        List<User> allUsers = userRepo.findAll();
        for (User toCheck : allUsers) {
            if (email.equals(toCheck.getEmail())) {
                isUnique = false;
            }

        }
        return isUnique;
    }

    public List<Integer> searchTag(String tag) {
        List<Tag> allTags = tagRepo.findAll();
        List<Integer> articleIds = new ArrayList();
        for (Tag aTag : allTags) {
            if (aTag.getName().equals(tag)) {
                Set<Article> theArticle = aTag.getArticles();
                for (Article aArt : theArticle) {
                    articleIds.add(aArt.getArticle_id());
                }
            }
        }
        return articleIds;
    }

    public List<Article> getAllArticles() {
        return artRepo.findAll();
    }

    public List<Article> getAllArticles(String tag) {
        Tag aTag = tagRepo.findAll().stream().filter(t -> t.getName().equals(tag)).findAny().orElse(null);
        if (aTag == null) {
            return new ArrayList<>();
        }

        return new ArrayList<>(aTag.getArticles());
    }
}
