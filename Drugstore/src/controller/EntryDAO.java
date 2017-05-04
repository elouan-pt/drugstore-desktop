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
import model.Entry;
import model.Product;
import model.ProofOfPayment;
import model.Supplier;

/**
 *
 * @author Sergio Pastor
 */
public class EntryDAO {

    public static Boolean insertEntry(Entry e) {
        Connection connection = Database.getConnection();
        PreparedStatement ps;
        boolean check = true;
        try {
            ps = connection.prepareStatement("INSERT INTO entry(product_id, entry_unit_price, entry_profit_percentage, quantity, batch, supplier_id, proof_of_payment_id, sanitary_register, arrival_date, expiry_date) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setInt(1, e.getProduct().getProductID());
            ps.setDouble(2, e.getEntryUnitPrice());
            ps.setDouble(3, e.getEntryProfitPercentage());
            ps.setInt(4, e.getQuantity());
            ps.setString(5, e.getBatch());
            ps.setInt(6, e.getSupplier().getSupplierID());
            ps.setInt(7, e.getProofOfPayment().getProofOfPaymentID());
            ps.setString(8, e.getSanitaryRegister());
            ps.setDate(9, e.getArrivalDate());
            ps.setDate(10, e.getExpiryDate());
            ps.executeUpdate();

            ps = connection.prepareStatement("SELECT LAST_INSERT_ID()");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                e.setEntryID(rs.getInt(1));
            }

            ps.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(EntryDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("SQLException: " + ex.getMessage());
            check = false;
        }
        return check;
    }
    
    public static Boolean updateEntry(Entry e) {
        Connection connection = Database.getConnection();
        PreparedStatement ps;
        boolean check = true;
        try {
            ps = connection.prepareStatement("UPDATE entry SET product_id = ?, entry_unit_price = ?, entry_profit_percentage = ?, quantity = ?, batch = ?, supplier_id = ?, proof_of_payment_id = ?, sanitary_register = ?, arrival_date = ?, expiry_date = ? WHERE entry_id = ?");
            ps.setInt(1, e.getProduct().getProductID());
            ps.setDouble(2, e.getEntryUnitPrice());
            ps.setDouble(3, e.getEntryProfitPercentage());
            ps.setInt(4, e.getQuantity());
            ps.setString(5, e.getBatch());
            ps.setInt(6, e.getSupplier().getSupplierID());
            ps.setInt(7, e.getProofOfPayment().getProofOfPaymentID());
            ps.setString(8, e.getSanitaryRegister());
            ps.setDate(9, e.getArrivalDate());
            ps.setDate(10, e.getExpiryDate());
            ps.setInt(11, e.getEntryID());
            ps.executeUpdate();

            ps.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(EntryDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("SQLException: " + ex.getMessage());
            check = false;
        }
        return check;
    }
    
    public static List<Entry> listEntriesOfProduct(int productID) {
        List<Entry> list = new ArrayList<>();
        Connection connection = Database.getConnection();
        PreparedStatement ps;
        final String QUERY = "SELECT e.entry_id, e.product_id, e.entry_unit_price, e.entry_profit_percentage, e.quantity, e.batch, e.supplier_id, sup.supplier_name, e.proof_of_payment_id, pop.number, pop.type, e.sanitary_register, e.arrival_date, e.expiry_date FROM entry e INNER JOIN supplier sup ON e.supplier_id = sup.supplier_id INNER JOIN proof_of_payment pop ON e.proof_of_payment_id = pop.proof_of_payment_id WHERE e.product_id = ? AND pop.active = 1 ORDER BY e.arrival_date";
        try {
            ps = connection.prepareStatement(QUERY);
            ps.setInt(1, productID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                
                Entry e = new Entry();
                e.setEntryID(rs.getInt(1));
                
                Product p = new Product();
                p.setProductID(rs.getInt(2));
                e.setProduct(p);
                
                e.setEntryUnitPrice(rs.getDouble(3));
                e.setEntryProfitPercentage(rs.getDouble(4));
                e.setQuantity(rs.getInt(5));
                e.setBatch(rs.getString(6));
                
                Supplier sup = new Supplier();
                sup.setSupplierID(rs.getInt(7));
                sup.setSupplierName(rs.getString(8));
                e.setSupplier(sup);
                
                ProofOfPayment pop = new ProofOfPayment();
                pop.setProofOfPaymentID(rs.getInt(9));
                pop.setNumber(rs.getString(10));
                pop.setType(rs.getString(11));
                e.setProofOfPayment(pop);
                
                e.setSanitaryRegister(rs.getString(12));
                e.setArrivalDate(rs.getDate(13));
                e.setExpiryDate(rs.getDate(14));
                
                list.add(e);
            }

            ps.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(EntryDAO.class.getName()).log(Level.SEVERE, null, ex);
            list = null;
        }
        return list;
    }
}
