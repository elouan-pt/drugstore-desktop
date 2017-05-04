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
import model.PaymentResumeReport;

/**
 *
 * @author Usuario
 */
public class PaymentResumeReportDAO {

    public static List<PaymentResumeReport> listOfPaymentResumeReports(Date beginDate, Date endDate) {
        List<PaymentResumeReport> list = new ArrayList<>();
        Connection connection = Database.getConnection();
        PreparedStatement ps;
        final String QUERY = "SELECT s.sale_date, SUM(s.total) FROM sale s INNER JOIN proof_of_payment pop ON s.proof_of_payment_id = pop.proof_of_payment_id WHERE (sale_date BETWEEN ? AND ?) AND pop.active = 1 GROUP BY sale_date ORDER BY 1";
        try {
            ps = connection.prepareStatement(QUERY);
            ps.setDate(1, beginDate);
            ps.setDate(2, endDate);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                PaymentResumeReport report = new PaymentResumeReport();
                GregorianCalendar gc = new GregorianCalendar();
                gc.setTime(rs.getDate(1));
                String day = "0" + gc.get(GregorianCalendar.DAY_OF_MONTH), month = "0" + (gc.get(GregorianCalendar.MONTH) + 1), year = "0" + gc.get(GregorianCalendar.YEAR);
                String date = day.substring(day.length() - 2) + "/" + month.substring(month.length() - 2) + "/" + year.substring(year.length() - 4);
                report.setSaleDate(date);
                report.setTotal(rs.getDouble(2));

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
