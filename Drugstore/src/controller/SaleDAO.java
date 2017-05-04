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
import model.Form;
import model.Product;
import model.ProofOfPayment;
import model.Sale;
import model.SaleProductDetail;

/**
 *
 * @author Sergio Pastor
 */
public class SaleDAO {

    public static Boolean insertSale(Sale s) {
        Connection connection = Database.getConnection();
        PreparedStatement ps;
        boolean check = true;
        try {
            ps = connection.prepareStatement("INSERT INTO sale(proof_of_payment_id, employee_id, subtotal, igv, total, sale_date) VALUES (?, ?, ?, ?, ?, ?)");
            ps.setInt(1, s.getProofOfPayment().getProofOfPaymentID());
            ps.setInt(2, s.getEmployee().getEmployeeID());
            ps.setDouble(3, s.getSubtotal());
            ps.setDouble(4, s.getIgv());
            ps.setDouble(5, s.getTotal());
            ps.setDate(6, s.getSaleDate());
            ps.executeUpdate();

            ps = connection.prepareStatement("SELECT LAST_INSERT_ID()");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                s.setSaleID(rs.getInt(1));
            }

            ps.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(SaleDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("SQLException: " + ex.getMessage());
            check = false;
        }
        return check;
    }

    public static Sale existSale(String search) {
        Connection connection = Database.getConnection();
        PreparedStatement ps;
        final String QUERY = "SELECT s.* FROM sale s INNER JOIN proof_of_payment pop ON s.proof_of_payment_id = pop.proof_of_payment_id WHERE pop.number = '" + search + "' AND pop.active = 1";
        Sale s = null;
        try {
            ps = connection.prepareStatement(QUERY);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                s = new Sale();
                s.setSaleID(rs.getInt(1));

                ProofOfPayment pop = new ProofOfPayment();
                pop.setProofOfPaymentID(rs.getInt(2));
                s.setProofOfPayment(pop);

                s.setEmployee(new Employee(rs.getInt(3)));
                s.setSubtotal(rs.getDouble(4));
                s.setIgv(rs.getDouble(5));
                s.setTotal(rs.getDouble(6));
                s.setSaleDate(rs.getDate(7));
            }

            ps.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(SaleDAO.class.getName()).log(Level.SEVERE, null, ex);
            s = null;
        }
        return s;
    }

    public static List<SaleProductDetail> listDetailOfSale(String search) {
        List<SaleProductDetail> list = new ArrayList<>();
        Connection connection = Database.getConnection();
        PreparedStatement ps;
        final String QUERY = "SELECT p.description, f.form_id, f.detail, sp.quantity, sp.sale_price FROM proof_of_payment pop INNER JOIN sale s ON pop.proof_of_payment_id = s.proof_of_payment_id INNER JOIN sale_product sp ON s.sale_id = sp.sale_id INNER JOIN product p ON p.product_id = sp.product_id INNER JOIN form f ON p.form_id = f.form_id WHERE number = '" + search + "' AND pop.active = 1";
        try {
            ps = connection.prepareStatement(QUERY);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setDescription(rs.getString(1));
                Form f = new Form();
                f.setFormID(rs.getInt(2));
                f.setDetail(rs.getString(3));
                p.setForm(f);

                SaleProductDetail spd = new SaleProductDetail();
                spd.setProduct(p);
                spd.setQuantity(rs.getInt(4));
                spd.setSalePrice(rs.getDouble(5));

                list.add(spd);
            }

            ps.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(SaleDAO.class.getName()).log(Level.SEVERE, null, ex);
            list = null;
        }
        return list;
    }

}
