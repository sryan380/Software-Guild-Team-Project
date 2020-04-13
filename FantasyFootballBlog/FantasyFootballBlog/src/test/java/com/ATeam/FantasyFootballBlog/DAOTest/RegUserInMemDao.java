/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ATeam.FantasyFootballBlog.DAOTest;

import com.ATeam.FantasyFootballBlog.Daos.RegisterUserDao;
import com.ATeam.FantasyFootballBlog.models.registerUser;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author davidsteffes
 */
public class RegUserInMemDao implements RegisterUserDao {

    List<registerUser> listOfRegisteredUsers = new ArrayList<>();

    public RegUserInMemDao() {

        registerUser testRegUser1 = new registerUser();
        testRegUser1.setId(34);
        testRegUser1.setUsername("Tim");
        testRegUser1.setPassword("kenobi");
        testRegUser1.setConfirmedPassword("kenobi");
        testRegUser1.setEnabled(true);
        testRegUser1.setFirst_name("Luke");
        testRegUser1.setLast_name("Skywalker");
        testRegUser1.setEmail("jediemail");
        listOfRegisteredUsers.add(testRegUser1);

        registerUser testRegUser2 = new registerUser();
        testRegUser2.setId(55);
        testRegUser2.setUsername("Karen");
        testRegUser2.setPassword("vader");
        testRegUser2.setConfirmedPassword("vader");
        testRegUser2.setEnabled(true);
        testRegUser2.setFirst_name("Sara");
        testRegUser2.setLast_name("Falcor");
        testRegUser2.setEmail("neverendingemail");
        listOfRegisteredUsers.add(testRegUser2);
    }
}
