/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ATeam.FantasyFootballBlog.DAOTest;

import com.ATeam.FantasyFootballBlog.Daos.UserDao;
import com.ATeam.FantasyFootballBlog.models.Role;
import com.ATeam.FantasyFootballBlog.models.User;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author davidsteffes
 */
public class UserInMemDao implements UserDao {

    List<User> userList = new ArrayList<>();

    public UserInMemDao() {
        User testUser1 = new User();
        testUser1.setId(1234);
        testUser1.setUsername("breadmania");
        testUser1.setPassword("breadman");
        testUser1.setEnabled(true);
        testUser1.setFirst_name("Bob");
        testUser1.setLast_name("Smith");
        testUser1.setEmail("bobsemail");
        userList.add(testUser1);

        User testUser2 = new User();
        testUser2.setId(5678);
        testUser2.setUsername("firefly");
        testUser2.setPassword("grasshopper");
        testUser2.setEnabled(true);
        testUser2.setFirst_name("Jane");
        testUser2.setLast_name("Doe");
        testUser2.setEmail("janesemail");
        userList.add(testUser2);

    }

    @Override
    public User getUserById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User getUserByUsername(String username) {

        User toReturn = new User();

        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getUsername() == username) {
                toReturn = userList.get(i);
            }
            
        }
        return toReturn;
    }

    @Override
    public List<User> getAllUsers() {
        return userList;
    }

    @Override
    public void updateUser(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteUser(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User createUser(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
