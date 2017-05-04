/*
 * Copyright (c) 2015 Pastor Tantalean.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Pastor Tantalean - initial API and implementation and/or initial documentation
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Employee;
import model.User;

/**
 *
 * @author Sergio Pastor
 */
public class UserDAO {

    public static Boolean insertUser(User u) {
        Connection connection = Database.getConnection();
        PreparedStatement ps;
        boolean check = true;
        try {
            ps = connection.prepareStatement("INSERT INTO user (username, password_hash, employee_id) VALUES (?, ?, ?)");
            ps.setString(1, u.getUsername());
            ps.setString(2, u.getPasswordHash());
            ps.setInt(3, u.getEmployee().getEmployeeID());
            ps.executeUpdate();

            ps = connection.prepareStatement("SELECT LAST_INSERT_ID()");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                u.setUserID(rs.getInt(1));
            }

            ps.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("SQLException: " + ex.getMessage());
            check = false;
        }
        return check;
    }

    public static Boolean updateUser(User u) {
        Connection connection = Database.getConnection();
        PreparedStatement ps;
        final String QUERY = "UPDATE user SET password_hash = '" + u.getPasswordHash() + "' WHERE user_id = " + u.getUserID();
        boolean check = true;
        try {
            ps = connection.prepareStatement(QUERY);
            ps.executeUpdate();

            ps.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("SQLException: " + ex.getMessage());
            check = false;
        }
        return check;
    }

    public static Boolean existUsername(String username) {
        Connection connection = Database.getConnection();
        PreparedStatement ps;
        final String QUERY = "SELECT user_id, username, password_hash, employee_id, last_update FROM user where username = " + "'" + username + "'";
        boolean check = false;
        try {
            ps = connection.prepareStatement(QUERY);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                check = true;
            }

            ps.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            check = false;
        }
        return check;
    }

    public static List<User> listOfUsersByUsername(String search) {
        List<User> list = new ArrayList<>();
        Connection connection = Database.getConnection();
        PreparedStatement ps;
        final String QUERY = "SELECT u.user_id, u.username, u.password_hash, e.employee_id, e.first_name, e.last_name, e.email, e.phone_number, e.age FROM user u INNER JOIN employee e ON u.employee_id = e.employee_id WHERE e.active = 1 AND u.username LIKE " + "'%" + search + "%'" + " ORDER BY 2";
        try {
            ps = connection.prepareStatement(QUERY);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Employee e = new Employee();
                e.setEmployeeID(rs.getInt(4));
                e.setFirstName(rs.getString(5));
                e.setLastName(rs.getString(6));
                e.setEmail(rs.getString(7));
                e.setPhoneNumber(rs.getString(8));
                e.setAge(rs.getInt(9));

                User u = new User();
                u.setUserID(rs.getInt(1));
                u.setUsername(rs.getString(2));
                u.setPasswordHash(rs.getString(3));
                u.setEmployee(e);

                list.add(u);
            }

            ps.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            list = null;
        }
        return list;
    }

    public static User getUser(String search) {
        User u = new User();
        Connection connection = Database.getConnection();
        PreparedStatement ps;
        final String QUERY = "SELECT u.user_id, u.username, u.password_hash, e.employee_id, e.first_name, e.last_name, e.email, e.phone_number, e.age FROM user u INNER JOIN employee e ON u.employee_id = e.employee_id WHERE e.active = 1 AND u.username = '" + search + "'";
        try {
            ps = connection.prepareStatement(QUERY);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Employee e = new Employee();
                e.setEmployeeID(rs.getInt(4));
                e.setFirstName(rs.getString(5));
                e.setLastName(rs.getString(6));
                e.setEmail(rs.getString(7));
                e.setPhoneNumber(rs.getString(8));
                e.setAge(rs.getInt(9));

                u.setUserID(rs.getInt(1));
                u.setUsername(rs.getString(2));
                u.setPasswordHash(rs.getString(3));
                u.setEmployee(e);

            } else {
                u = null;
            }

            ps.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            u = null;
        }
        return u;
    }

}
