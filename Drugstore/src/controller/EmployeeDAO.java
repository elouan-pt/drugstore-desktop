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
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Employee;

/**
 *
 * @author Sergio Pastor
 */
public class EmployeeDAO {

    public static Boolean insertEmployee(Employee e) {
        Connection connection = Database.getConnection();
        PreparedStatement ps;
        boolean check = true;
        try {
            ps = connection.prepareStatement("INSERT INTO employee (first_name, last_name, email, phone_number, age) VALUES (?, ?, ?, ?, ?)");
            ps.setString(1, e.getFirstName());
            ps.setString(2, e.getLastName());
            ps.setString(3, e.getEmail());
            ps.setString(4, e.getPhoneNumber());
            ps.setInt(5, e.getAge());
            ps.executeUpdate();

            ps = connection.prepareStatement("SELECT LAST_INSERT_ID()");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                e.setEmployeeID(rs.getInt(1));
            }

            ps.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("SQLException: " + ex.getMessage());
            check = false;
        }
        return check;
    }

    public static Boolean updateEmployee(Employee e) {
        Connection connection = Database.getConnection();
        PreparedStatement ps;
        final String QUERY = "UPDATE employee SET first_name = '" + e.getFirstName() + "', last_name = '" + e.getLastName() + "', email = '" + e.getEmail() + "', phone_number = '" + e.getPhoneNumber() + "', age = " + e.getAge() + " WHERE employee_id = " + e.getEmployeeID();
        boolean check = true;
        try {
            ps = connection.prepareStatement(QUERY);
            ps.executeUpdate();

            ps.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("SQLException: " + ex.getMessage());
            check = false;
        }
        return check;
    }

    public static Boolean deleteEmployee(Employee e) {
        Connection connection = Database.getConnection();
        PreparedStatement ps;
        final String QUERY = "UPDATE employee SET active = 0 WHERE employee_id = " + e.getEmployeeID();
        boolean check = true;
        try {

            ps = connection.prepareStatement(QUERY);
            ps.executeUpdate();

            ps.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("SQLException: " + ex.getMessage());
            check = false;
        }
        return check;
    }
    
}
