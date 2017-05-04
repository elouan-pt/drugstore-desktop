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
public class Form {

    private int formID;
    private String detail;
    private Date lastUpdate;

    public Form() {
    }

    public Form(int formID) {
        this.formID = formID;
    }

    public Form(String detail) {
        this.detail = detail;
    }

    public Form(int formID, String detail, Date lastUpdate) {
        this.formID = formID;
        this.detail = detail;
        this.lastUpdate = lastUpdate;
    }

    public int getFormID() {
        return formID;
    }

    public void setFormID(int formID) {
        this.formID = formID;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString() {
        return detail;
    }

}
