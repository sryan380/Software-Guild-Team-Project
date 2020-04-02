/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ATeam.FantasyFootballBlog.Daos;

import com.ATeam.FantasyFootballBlog.models.Role;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Steve
 */
@Repository
public class RoleDaoDB implements RoleDao{
    
    @Autowired
    JdbcTemplate template;

    @Override
    public Role getRoleById(int roleId) {
        try {

            return template.queryForObject("SELECT * FROM `role` WHERE id = ?", new RoleMapper(), roleId);
        } catch (DataAccessException ex) {
            return null;
        }
    }

    @Override
    public Role getRoleByRole(String roleName) {
        try {

            return template.queryForObject("SELECT * FROM `role` WHERE role = ?", new RoleMapper(), roleName);
        } catch (DataAccessException ex) {
            return null;
        }
    }

    @Override
    public List<Role> getAllRoles() {

        return template.query("SELECT * FROM `role`", new RoleMapper());
    }
    
    public static class RoleMapper implements RowMapper<Role> {

        @Override
        public Role mapRow(ResultSet row, int i) throws SQLException {
            Role role = new Role();
            role.setId(row.getInt("id"));
            role.setRole(row.getString("role"));
            return role;
        }
    }
    
}
