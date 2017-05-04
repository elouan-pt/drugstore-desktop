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
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sergio Pastor
 */
public class Database {

    private static final String URL = "jdbc:mysql://localhost:3306/drugstore";
    private static final String USER = "root";
    private static final String PASSWORD = "lovemerandom";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("SQLException: " + ex.getMessage());
        }
        return connection;
    }
    
}
