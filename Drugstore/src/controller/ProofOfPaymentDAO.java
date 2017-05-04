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
import model.ProofOfPayment;
import model.User;

/**
 *
 * @author Sergio Pastor
 */
public class ProofOfPaymentDAO {
    
    public static Boolean insertProofOfPayment(ProofOfPayment pop) {
        Connection connection = Database.getConnection();
        PreparedStatement ps;
        boolean check = true;
        try {
            ps = connection.prepareStatement("INSERT INTO proof_of_payment(number, type) VALUES (?, ?)");
            ps.setString(1, pop.getNumber());
            ps.setString(2, pop.getType());
            ps.executeUpdate();

            ps = connection.prepareStatement("SELECT LAST_INSERT_ID()");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                pop.setProofOfPaymentID(rs.getInt(1));
            }

            ps.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProofOfPaymentDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("SQLException: " + ex.getMessage());
            check = false;
        }
        return check;
    }
    
     public static Boolean deleteProofOfPayment(ProofOfPayment pop, User u) {
        Connection connection = Database.getConnection();
        PreparedStatement ps;
        boolean check = true;
        try {
            ps = connection.prepareStatement("UPDATE proof_of_payment SET active = 0, comment = ? WHERE proof_of_payment_id = ?");
            ps.setString(1, u.getEmployee().toString());
            ps.setInt(2, pop.getProofOfPaymentID());
            ps.executeUpdate();

            ps.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProofOfPaymentDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("SQLException: " + ex.getMessage());
            check = false;
        }
        return check;
    }

}
