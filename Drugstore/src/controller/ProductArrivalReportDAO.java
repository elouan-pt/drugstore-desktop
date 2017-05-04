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
import model.ProductArrivalReport;

/**
 *
 * @author Usuario
 */
public class ProductArrivalReportDAO {

    public static List<ProductArrivalReport> listOfProductArrivalReports(Date beginDate, Date endDate) {
        List<ProductArrivalReport> list = new ArrayList<>();
        Connection connection = Database.getConnection();
        PreparedStatement ps;
        final String QUERY = "SELECT e.arrival_date, p.description, f.detail, e.entry_unit_price, e.quantity, (e.entry_unit_price * e.quantity) AS amount FROM entry e INNER JOIN product p ON e.product_id = p.product_id INNER JOIN form f ON p.form_id = f.form_id INNER JOIN proof_of_payment pop ON e.proof_of_payment_id = pop.proof_of_payment_id WHERE e.arrival_date BETWEEN ? AND ?  AND pop.active = 1 ORDER BY 1";
        try {
            ps = connection.prepareStatement(QUERY);
            ps.setDate(1, beginDate);
            ps.setDate(2, endDate);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ProductArrivalReport report = new ProductArrivalReport();
                GregorianCalendar gc = new GregorianCalendar();
                gc.setTime(rs.getDate(1));
                String day = "0" + gc.get(GregorianCalendar.DAY_OF_MONTH), month = "0" + (gc.get(GregorianCalendar.MONTH) + 1), year = "0" + gc.get(GregorianCalendar.YEAR);
                String date = day.substring(day.length() - 2) + "/" + month.substring(month.length() - 2) + "/" + year.substring(year.length() - 4);
                report.setArrivalDate(date);
                report.setDescription(rs.getString(2));
                report.setDetail(rs.getString(3));
                report.setEntryUnitPrice(rs.getDouble(4));
                report.setQuantity(rs.getInt(5));
                report.setAmount(rs.getDouble(6));

                list.add(report);
            }

            ps.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductArrivalReportDAO.class.getName()).log(Level.SEVERE, null, ex);
            list = null;
        }
        return list;
    }
}
