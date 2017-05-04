/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.BalanceReport;
import model.PaymentResumeReport;

/**
 *
 * @author Usuario
 */
public class BalanceReportDAO {
    public static List<BalanceReport> listOfBalanceReports() {
        List<BalanceReport> list = new ArrayList<>();
        Connection connection = Database.getConnection();
        PreparedStatement ps;
        final String QUERY = "SELECT p.description, f.detail, p.stock, p.sale_price, (p.stock * p.sale_price) AS amount FROM product p INNER JOIN form f ON p.form_id = f.form_id WHERE p.stock > 0";
        try {
            ps = connection.prepareStatement(QUERY);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                BalanceReport report = new BalanceReport();
                report.setDescription(rs.getString(1));
                report.setDetail(rs.getString(2));
                report.setStock(rs.getInt(3));
                report.setSalePrice(rs.getDouble(4));
                report.setAmount(rs.getDouble(5));

                list.add(report);
            }

            ps.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(PaymentResumeReportDAO.class.getName()).log(Level.SEVERE, null, ex);
            list = null;
        }
        return list;
    }
}
