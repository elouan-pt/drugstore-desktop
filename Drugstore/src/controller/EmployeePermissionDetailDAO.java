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
import model.EmployeePermissionDetail;
import model.Permission;

/**
 *
 * @author Sergio Pastor
 */
public class EmployeePermissionDetailDAO {

    public static Boolean insertEmployeePermissionDetail(EmployeePermissionDetail epd) {
        Connection connection = Database.getConnection();
        PreparedStatement ps;
        boolean check = true;
        try {
            ps = connection.prepareStatement("INSERT INTO employee_permission(employee_id, permission_id) VALUES (?, ?)");
            ps.setInt(1, epd.getEmployee().getEmployeeID());
            ps.setInt(2, epd.getPermission().getPermissionID());
            ps.executeUpdate();

            ps.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(EmployeePermissionDetailDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("SQLException: " + ex.getMessage());
            check = false;
        }
        return check;
    }
    
    public static Boolean deletePermissionByEmployeeID(int employeeID) {
        Connection connection = Database.getConnection();
        PreparedStatement ps;
        boolean check = true;
        final String QUERY = "DELETE FROM employee_permission WHERE employee_id = " + employeeID;
        try {
            ps = connection.prepareStatement(QUERY);
            ps.executeUpdate();

            ps.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(EmployeePermissionDetailDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("SQLException: " + ex.getMessage());
            check = false;
        }
        return check;
    }

    public static List<Permission> permissionsByEmployeeID(int employeeID) {

        List<Permission> list = new ArrayList<>();
        Connection connection = Database.getConnection();
        PreparedStatement ps;
        final String QUERY = "SELECT permission_id FROM employee_permission WHERE employee_id = " + employeeID;
        try {
            ps = connection.prepareStatement(QUERY);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Permission(rs.getInt(1)));
            }

            ps.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(EmployeePermissionDetailDAO.class.getName()).log(Level.SEVERE, null, ex);
            list = null;
        }
        return list;
    }
}
