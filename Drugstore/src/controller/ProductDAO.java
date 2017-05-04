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
import model.Product;

/**
 *
 * @author Sergio Pastor
 */
public class ProductDAO {
    public static Boolean insertProduct(Product p) {
        Connection connection = Database.getConnection();
        PreparedStatement ps;
        boolean check = true;
        try {
            ps = connection.prepareStatement("INSERT INTO product(description, form_id, product_unit_price, product_profit_percentage, sale_price, stock) VALUES (?, ?, ?, ?, ?, ?)");
            ps.setString(1, p.getDescription());
            ps.setInt(2, p.getForm().getFormID());
            ps.setDouble(3, p.getProductUnitPrice());
            ps.setDouble(4, p.getProductProfitPercentage());
            ps.setDouble(5, p.getSalePrice());
            ps.setInt(6, p.getStock());
            ps.executeUpdate();

            ps = connection.prepareStatement("SELECT LAST_INSERT_ID()");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                p.setProductID(rs.getInt(1));
            }

            ps.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("SQLException: " + ex.getMessage());
            check = false;
        }
        return check;
    }
    
    public static Boolean updateProduct(Product p) {
        Connection connection = Database.getConnection();
        PreparedStatement ps;
        final String QUERY = "UPDATE product SET description = ?, form_id = ?, product_unit_price = ?, product_profit_percentage = ?, sale_price = ?, stock = ? WHERE product_id = ?";
        boolean check = true;
        try {
            ps = connection.prepareStatement(QUERY);
            ps.setString(1, p.getDescription());
            ps.setInt(2, p.getForm().getFormID());
            ps.setDouble(3, p.getProductUnitPrice());
            ps.setDouble(4, p.getProductProfitPercentage());
            ps.setDouble(5, p.getSalePrice());
            ps.setInt(6, p.getStock());
            ps.setInt(7, p.getProductID());
            ps.executeUpdate();

            ps.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("SQLException: " + ex.getMessage());
            check = false;
        }
        return check;
    }
    
    public static Boolean getProduct(Product p) {
        Connection connection = Database.getConnection();
        PreparedStatement ps;
        final String QUERY = "SELECT product_id, stock FROM product WHERE description = '" + p.getDescription() + "' AND form_id = '" + p.getForm().getFormID() + "'";
        boolean check = false;
        try {
            ps = connection.prepareStatement(QUERY);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                check = true;
                p.setProductID(rs.getInt(1));
                p.setStock(p.getStock() + rs.getInt(2));
            }

            if (check) {
                check = updateProduct(p);
            } else {
                check = insertProduct(p);
            }

            ps.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
            check = false;
        }
        return check;
    }
    
    public static List<Product> listOfProductsByDescription(String search) {
        List<Product> list = new ArrayList<>();
        Connection connection = Database.getConnection();
        PreparedStatement ps;
        final String QUERY = "SELECT p.product_id, p.description, f.form_id, f.detail, p.product_unit_price, p.product_profit_percentage, p.sale_price, p.stock FROM product p INNER JOIN form f ON p.form_id = f.form_id WHERE description LIKE '%" + search + "%' ORDER BY 2";
        try {
            ps = connection.prepareStatement(QUERY);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Form f = new Form();
                f.setFormID(rs.getInt(3));
                f.setDetail(rs.getString(4));
                
                Product p = new Product();
                p.setProductID(rs.getInt(1));
                p.setDescription(rs.getString(2));
                p.setForm(f);
                p.setProductUnitPrice(rs.getDouble(5));
                p.setProductProfitPercentage(rs.getDouble(6));
                p.setSalePrice(rs.getDouble(7));
                p.setStock(rs.getInt(8));
                
                list.add(p);
            }
            
            ps.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
            list = null;
        }
        return list;
    }
    
    public static List<Product> listOfProducts() {
        List<Product> list = new ArrayList<>();
        Connection connection = Database.getConnection();
        PreparedStatement ps;
        final String QUERY = "SELECT p.product_id, CONCAT(p.description, ' - ', f.detail) AS description FROM product p INNER JOIN form f ON p.form_id = f.form_id ORDER BY 2";
        try {
            ps = connection.prepareStatement(QUERY);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                Product p = new Product();
                p.setProductID(rs.getInt(1));
                p.setDescription(rs.getString(2));
                
                list.add(p);
            }
            
            ps.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
            list = null;
        }
        return list;
    }


}
