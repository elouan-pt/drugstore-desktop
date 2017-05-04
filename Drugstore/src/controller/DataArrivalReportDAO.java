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
import model.DataArrivalReport;

/**
 *
 * @author Sergio Pastor
 */
public class DataArrivalReportDAO {

    public static List<DataArrivalReport> listOfDataArrivalReports(Date beginDate, Date endDate) {
        List<DataArrivalReport> list = new ArrayList<>();
        Connection connection = Database.getConnection();
        PreparedStatement ps;
        final String QUERY = "SELECT e.arrival_date, p.description, f.detail, pop.number, pop.type, e.quantity, e.batch, sup.supplier_name, e.sanitary_register, e.expiry_date FROM entry e INNER JOIN product p ON e.product_id = p.product_id INNER JOIN form f ON p.form_id = f.form_id INNER JOIN supplier sup ON e.supplier_id = sup.supplier_id INNER JOIN proof_of_payment pop ON e.proof_of_payment_id = pop.proof_of_payment_id WHERE e.arrival_date BETWEEN ? AND ? AND pop.active = 1 ORDER BY 1";
        try {
            ps = connection.prepareStatement(QUERY);
            ps.setDate(1, beginDate);
            ps.setDate(2, endDate);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DataArrivalReport report = new DataArrivalReport();
                GregorianCalendar gc = new GregorianCalendar();
                gc.setTime(rs.getDate(1));
                String day = "0" + gc.get(GregorianCalendar.DAY_OF_MONTH), month = "0" + (gc.get(GregorianCalendar.MONTH) + 1), year = "0" + gc.get(GregorianCalendar.YEAR);
                String date = day.substring(day.length() - 2) + "/" + month.substring(month.length() - 2) + "/" + year.substring(year.length() - 4);
                
                report.setArrivalDate(date);
                report.setDescription(rs.getString(2));
                report.setDetail(rs.getString(3));
                report.setProofOfPayment(rs.getString(4));
                report.setType(rs.getString(5));
                report.setQuantity(rs.getInt(6));
                report.setBatch(rs.getString(7));
                report.setSupplier(rs.getString(8));
                report.setSanitaryRegister(rs.getString(9));
                
                gc = new GregorianCalendar();
                gc.setTime(rs.getDate(10));
                day = "0" + gc.get(GregorianCalendar.DAY_OF_MONTH);
                month = "0" + (gc.get(GregorianCalendar.MONTH) + 1);
                year = "0" + gc.get(GregorianCalendar.YEAR);
                date = day.substring(day.length() - 2) + "/" + month.substring(month.length() - 2) + "/" + year.substring(year.length() - 4);
                
                report.setExpiryDate(date);
                
                list.add(report);
            }

            ps.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataArrivalReportDAO.class.getName()).log(Level.SEVERE, null, ex);
            list = null;
        }
        return list;
    }

}
