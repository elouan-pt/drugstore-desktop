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
import java.util.Collections;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.KardexReport;
import model.Product;

/**
 *
 * @author Usuario
 */
public class KardexReportDAO {

    public static List<KardexReport> listOfKardexReports(Date beginDate, Date endDate, Product p) {
        List<KardexReport> list = new ArrayList<>();
        Connection connection = Database.getConnection();
        PreparedStatement ps;
        final String QUERY1 = "SELECT e.arrival_date, p.description, f.detail, e.entry_unit_price, e.quantity, (e.entry_unit_price * e.quantity) AS amount FROM entry e INNER JOIN product p ON e.product_id = p.product_id INNER JOIN form f ON p.form_id = f.form_id INNER JOIN proof_of_payment pop ON e.proof_of_payment_id = pop.proof_of_payment_id WHERE (e.arrival_date BETWEEN ? AND ?) AND p.product_id = ? AND pop.active = 1";
        //final String QUERY2 = "SELECT s.sale_date, p.description, f.detail, sd.sale_price, sd.quantity, (sd.sale_price * sd.quantity) AS amount FROM sale s INNER JOIN sale_product sd ON s.sale_id = sd.sale_id INNER JOIN product p ON sd.product_id = p.product_id INNER JOIN form f ON p.form_id = f.form_id WHERE (s.sale_date BETWEEN ? AND ?) AND p.product_id = ?";
        final String QUERY2 = "SELECT s.sale_date, p.description, f.detail, sd.sale_price, sd.quantity, sd.sale_total_price AS amount FROM sale s INNER JOIN sale_product sd ON s.sale_id = sd.sale_id INNER JOIN product p ON sd.product_id = p.product_id INNER JOIN form f ON p.form_id = f.form_id INNER JOIN proof_of_payment pop ON s.proof_of_payment_id = pop.proof_of_payment_id WHERE (s.sale_date BETWEEN ? AND ?) AND p.product_id = ? AND pop.active = 1";
        try {
            ps = connection.prepareStatement(QUERY1);
            ps.setDate(1, beginDate);
            ps.setDate(2, endDate);
            ps.setInt(3, p.getProductID());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KardexReport report = new KardexReport();

                GregorianCalendar gc = new GregorianCalendar();
                gc.setTime(rs.getDate(1));
                String day = "0" + gc.get(GregorianCalendar.DAY_OF_MONTH), month = "0" + (gc.get(GregorianCalendar.MONTH) + 1), year = "0" + gc.get(GregorianCalendar.YEAR);
                String date = day.substring(day.length() - 2) + "/" + month.substring(month.length() - 2) + "/" + year.substring(year.length() - 4);

                report.setDate(date);
                report.setDescription(rs.getString(2));
                report.setDetail(rs.getString(3));
                report.setEntryPrice(rs.getDouble(4) + "");
                report.setEntryQuantity(rs.getInt(5) + "");
                report.setAmount(rs.getDouble(6) + "");

                list.add(report);
            }

            ps = connection.prepareStatement(QUERY2);
            ps.setDate(1, beginDate);
            ps.setDate(2, endDate);
            ps.setInt(3, p.getProductID());
            rs = ps.executeQuery();
            while (rs.next()) {
                KardexReport report = new KardexReport();

                GregorianCalendar gc = new GregorianCalendar();
                gc.setTime(rs.getDate(1));
                String day = "0" + gc.get(GregorianCalendar.DAY_OF_MONTH), month = "0" + (gc.get(GregorianCalendar.MONTH) + 1), year = "0" + gc.get(GregorianCalendar.YEAR);
                String date = day.substring(day.length() - 2) + "/" + month.substring(month.length() - 2) + "/" + year.substring(year.length() - 4);

                report.setDate(date);
                report.setDescription(rs.getString(2));
                report.setDetail(rs.getString(3));
                report.setSalePrice(rs.getDouble(4) + "");
                report.setSaleQuantity(rs.getInt(5) + "");
                report.setAmount(rs.getDouble(6) + "");

                list.add(report);
            }

            ps.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(KardexReportDAO.class.getName()).log(Level.SEVERE, null, ex);
            list = null;
        }

        Collections.sort(list, new Comparator<KardexReport>() {

            @Override
            public int compare(KardexReport o1, KardexReport o2) {
                String d1 = o1.getDate();
                String d2 = o2.getDate();
                int day = Integer.parseInt(d1.substring(0, 2)), month = Integer.parseInt(d1.substring(3, 5)) - 1, year = Integer.parseInt(d1.substring(6));
                GregorianCalendar gc1 = new GregorianCalendar(year, month, day);

                day = Integer.parseInt(d2.substring(0, 2));
                month = Integer.parseInt(d2.substring(3, 5)) - 1;
                year = Integer.parseInt(d2.substring(6));
                GregorianCalendar gc2 = new GregorianCalendar(year, month, day);

                return gc1.compareTo(gc2);
            }
        });

        return list;
    }
}
