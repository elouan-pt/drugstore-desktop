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
package model;

import java.util.Date;

/**
 *
 * @author Sergio Pastor
 */
public class User {

    private int userID;
    private String username;
    private String passwordHash;
    private Employee employee;
    private Date lastUpdate;

    public User() {
    }

    public User(String username, String passwordHash, Employee employee) {
        this.username = username;
        this.passwordHash = passwordHash;
        this.employee = employee;
    }

    public User(int userID, String username, String passwordHash, Employee employee, Date lastUpdate) {
        this.userID = userID;
        this.username = username;
        this.passwordHash = passwordHash;
        this.employee = employee;
        this.lastUpdate = lastUpdate;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString() {
        return username;
    }

}
