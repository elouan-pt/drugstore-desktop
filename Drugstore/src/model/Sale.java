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

import java.sql.Date;

/**
 *
 * @author Sergio Pastor
 */
public class Sale {

    private int saleID;
    private ProofOfPayment proofOfPayment;
    private Employee employee;
    private double subtotal;
    private double igv;
    private double total;
    private Date saleDate;
    private Date lastUpdate;

    public Sale() {
    }

    public Sale(ProofOfPayment proofOfPayment, Employee employee, double subtotal, double igv, double total, Date saleDate) {
        this.proofOfPayment = proofOfPayment;
        this.employee = employee;
        this.subtotal = subtotal;
        this.igv = igv;
        this.total = total;
        this.saleDate = saleDate;
    }

    public Sale(int saleID, ProofOfPayment proofOfPayment, Employee employee, Date saleDate, Date lastUpdate) {
        this.saleID = saleID;
        this.proofOfPayment = proofOfPayment;
        this.employee = employee;
        this.saleDate = saleDate;
        this.lastUpdate = lastUpdate;
    }

    public int getSaleID() {
        return saleID;
    }

    public void setSaleID(int saleID) {
        this.saleID = saleID;
    }

    public ProofOfPayment getProofOfPayment() {
        return proofOfPayment;
    }

    public void setProofOfPayment(ProofOfPayment proofOfPayment) {
        this.proofOfPayment = proofOfPayment;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getIgv() {
        return igv;
    }

    public void setIgv(double igv) {
        this.igv = igv;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Date getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

}
