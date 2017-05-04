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
import model.SaleProductDetail;

/**
 *
 * @author Sergio Pastor
 */
public class SaleProductDetailDAO {

    public static Boolean insertSaleProductDetail(SaleProductDetail spd) {
        Connection connection = Database.getConnection();
        PreparedStatement ps;
        boolean check = true;
        try {
            ps = connection.prepareStatement("INSERT INTO sale_product(sale_id, product_id, quantity, sale_price, sale_total_price) VALUES (?, ?, ?, ?, ?)");
            ps.setInt(1, spd.getSale().getSaleID());
            ps.setInt(2, spd.getProduct().getProductID());
            ps.setInt(3, spd.getQuantity());
            ps.setDouble(4, spd.getSalePrice());
            ps.setDouble(5, spd.getSaleTotalPrice());
            ps.executeUpdate();

            ps = connection.prepareStatement("SELECT LAST_INSERT_ID()");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                spd.setSaleProductID(rs.getInt(1));
            }

            ps.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(SaleProductDetailDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("SQLException: " + ex.getMessage());
            check = false;
        }
        return check;
    }
}
