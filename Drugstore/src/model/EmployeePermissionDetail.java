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
public class EmployeePermissionDetail {

    private int employeePermissionID;
    private Employee employee;
    private Permission permission;
    private Date lastUpdate;

    public EmployeePermissionDetail() {
    }

    public EmployeePermissionDetail(Employee employee, Permission permission) {
        this.employee = employee;
        this.permission = permission;
    }

    public EmployeePermissionDetail(int employeePermissionID, Employee employee, Permission permission, Date lastUpdate) {
        this.employeePermissionID = employeePermissionID;
        this.employee = employee;
        this.permission = permission;
        this.lastUpdate = lastUpdate;
    }

    public int getEmployeePermissionID() {
        return employeePermissionID;
    }

    public void setEmployeePermissionID(int employeePermissionID) {
        this.employeePermissionID = employeePermissionID;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Permission getPermission() {
        return permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

}
