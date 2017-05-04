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
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Form;
import model.Product;
import model.User;

/**
 *
 * @author Sergio Pastor
 */
public class FormDAO {
    
    public static Boolean insertForm(Form f) {
        Connection connection = Database.getConnection();
        PreparedStatement ps;
        boolean check = true;
        try {
            ps = connection.prepareStatement("INSERT INTO form(detail) VALUES (?)");
            ps.setString(1, f.getDetail());
            ps.executeUpdate();

            ps = connection.prepareStatement("SELECT LAST_INSERT_ID()");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                f.setFormID(rs.getInt(1));
            }

            ps.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(FormDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("SQLException: " + ex.getMessage());
            check = false;
        }
        return check;
    }

    public static Boolean getForm(Form f) {
        Connection connection = Database.getConnection();
        PreparedStatement ps;
        final String QUERY = "SELECT form_id, detail FROM form where detail = '" + f.getDetail() + "'";
        boolean check = false;
        try {
            ps = connection.prepareStatement(QUERY);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                check = true;
                f.setFormID(rs.getInt(1));
            }
            
            if (!check) {
                check = insertForm(f);
            }
            
            ps.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(FormDAO.class.getName()).log(Level.SEVERE, null, ex);
            check = false;
        }
        return check;
    }
    
    
    public static List<Form> listOfFormsByDetail(String search) {
        List<Form> list = new ArrayList<>();
        Connection connection = Database.getConnection();
        PreparedStatement ps;
        final String QUERY = "SELECT form_id, detail FROM form WHERE detail LIKE '" + search + "%' ORDER BY 2";
        try {
            ps = connection.prepareStatement(QUERY);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Form f = new Form();
                f.setFormID(rs.getInt(1));
                f.setDetail(rs.getString(2));
                
                list.add(f);
            }
            
            ps.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(FormDAO.class.getName()).log(Level.SEVERE, null, ex);
            list = null;
        }
        return list;
    }

}
