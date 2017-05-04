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
import model.Form;
import model.Supplier;

/**
 *
 * @author Sergio Pastor
 */
public class SupplierDAO {

    public static Boolean insertSupplier(Supplier s) {
        Connection connection = Database.getConnection();
        PreparedStatement ps;
        boolean check = true;
        try {
            ps = connection.prepareStatement("INSERT INTO supplier(supplier_name) VALUES (?)");
            ps.setString(1, s.getSupplierName());
            ps.executeUpdate();

            ps = connection.prepareStatement("SELECT LAST_INSERT_ID()");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                s.setSupplierID(rs.getInt(1));
            }

            ps.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(SupplierDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("SQLException: " + ex.getMessage());
            check = false;
        }
        return check;
    }

    public static Boolean getSupplier(Supplier s) {
        Connection connection = Database.getConnection();
        PreparedStatement ps;
        final String QUERY = "SELECT supplier_id, supplier_name FROM supplier WHERE supplier_name = '" + s.getSupplierName() + "'";
        boolean check = false;
        try {
            ps = connection.prepareStatement(QUERY);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                check = true;
                s.setSupplierID(rs.getInt(1));
            }

            if (!check) {
                check = insertSupplier(s);
            }

            ps.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(SupplierDAO.class.getName()).log(Level.SEVERE, null, ex);
            check = false;
        }
        return check;
    }

    public static List<Supplier> listOfSuppliersBySupplierName(String search) {
        List<Supplier> list = new ArrayList<>();
        Connection connection = Database.getConnection();
        PreparedStatement ps;
        final String QUERY = "SELECT supplier_id, supplier_name FROM supplier WHERE supplier_name LIKE '" + search + "%' ORDER BY 2";
        try {
            ps = connection.prepareStatement(QUERY);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Supplier s = new Supplier();
                s.setSupplierID(rs.getInt(1));
                s.setSupplierName(rs.getString(2));

                list.add(s);
            }

            ps.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(SupplierDAO.class.getName()).log(Level.SEVERE, null, ex);
            list = null;
        }
        return list;
    }

}
