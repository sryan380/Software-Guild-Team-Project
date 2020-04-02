/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ATeam.FantasyFootballBlog.Daos;

import com.ATeam.FantasyFootballBlog.Daos.RoleDaoDB.RoleMapper;
import com.ATeam.FantasyFootballBlog.models.Role;
import com.ATeam.FantasyFootballBlog.models.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Steve
 */
@Repository
public class UserDaoDB implements UserDao {

    @Autowired
    JdbcTemplate template;

    private Set<Role> getRolesForUser(int id) throws DataAccessException {

        Set<Role> roles = new HashSet(template.query(
                "SELECT r.* FROM user_role ur "
                + "JOIN role r ON ur.role_id = r.id "
                + "WHERE ur.user_id = ?", new RoleMapper(), id));
        return roles;
    }

    @Override
    public User getUserById(int id) {
        try {
            User user = template.queryForObject("SELECT * FROM user WHERE id = ?", new UserMapper(), id);
            user.setRoles(getRolesForUser(user.getId()));
            return user;
        } catch (DataAccessException ex) {
            return null;
        }
    }

    @Override
    public User getUserByUsername(String username) {
        try {
            User user = template.queryForObject("SELECT * FROM user WHERE username = ?", new UserMapper(), username);
            user.setRoles(getRolesForUser(user.getId()));
            return user;
        } catch (DataAccessException ex) {
            return null;
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> allUsers = template.query("SELECT * FROM user", new UserMapper());
        for (User user : allUsers) {
            user.setRoles(getRolesForUser(user.getId()));
        }
        return allUsers;
    }

    @Override
    @Transactional
    public void updateUser(User newData) {

        template.update("UPDATE newData SET newDataname = ?, password = ?,enabled = ? WHERE id = ?", newData.getUsername(), newData.getPassword(), newData.isEnabled(), newData.getId());

        template.update("DELETE FROM newData_role WHERE newData_id = ?", newData.getId());
        for (Role role : newData.getRoles()) {
            template.update("INSERT INTO newData_role(newData_id, role_id) VALUES(?,?)",
                    newData.getId(), role.getId());
        }
    }

    @Override
    public void deleteUser(int id) {

        template.update("DELETE FROM user_role WHERE user_id = ?", id);
        template.update("DELETE FROM user WHERE id = ?", id);
    }

    @Override
    @Transactional
    public User createUser(User toAdd) {

        KeyHolder kh = new GeneratedKeyHolder();

        int rowsAffected = template.update(
                connection -> {
                    PreparedStatement ps = connection.prepareStatement(
                            "INSERT INTO user(username, password, enabled) VALUES(?,?,?)",
                            Statement.RETURN_GENERATED_KEYS
                    );
                    
                    ps.setString(1, toAdd.getUsername());
                    ps.setString(2, toAdd.getPassword());
                    ps.setBoolean(3, toAdd.isEnabled());
                    
                    return ps;
                    
                },
                kh);
        
        int generatedId = kh.getKey().intValue();
        
        toAdd.setId(generatedId);

        for (Role role : toAdd.getRoles()) {
            template.update("INSERT INTO user_role(user_id, role_id) VALUES(?,?)",
                    generatedId,
                    role.getId());
        }
        
        return toAdd;
    }

    public static final class UserMapper implements RowMapper<User> {

        @Override
        public User mapRow(ResultSet row, int i) throws SQLException {
            User user = new User();
            user.setId(row.getInt("id"));
            user.setUsername(row.getString("username"));
            user.setPassword(row.getString("password"));
            user.setEnabled(row.getBoolean("enabled"));
            return user;
        }
    }
}
