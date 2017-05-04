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
public class Entry {

    private int entryID;
    private Product product;
    private Supplier supplier;
    private double entryUnitPrice;
    private double entryProfitPercentage;
    private int quantity;
    private String batch;
    private ProofOfPayment proofOfPayment;
    private String sanitaryRegister;
    private Date arrivalDate;
    private Date expiryDate;
    private Date lastUpdate;

    public Entry() {
    }

    public Entry(Product product, Supplier supplier, double entryUnitPrice, double entryProfitPercentage, int quantity, String batch, ProofOfPayment proofOfPayment, String sanitaryRegister, Date arrivalDate, Date expiryDate) {
        this.product = product;
        this.supplier = supplier;
        this.entryUnitPrice = entryUnitPrice;
        this.entryProfitPercentage = entryProfitPercentage;
        this.quantity = quantity;
        this.batch = batch;
        this.proofOfPayment = proofOfPayment;
        this.sanitaryRegister = sanitaryRegister;
        this.arrivalDate = arrivalDate;
        this.expiryDate = expiryDate;
    }

    public Entry(int entryID, Product product, Supplier supplier, double entryUnitPrice, double entryProfitPercentage, int quantity, String batch, ProofOfPayment proofOfPayment, String sanitaryRegister, Date arrivalDate, Date expiryDate, Date lastUpdate) {
        this.entryID = entryID;
        this.product = product;
        this.supplier = supplier;
        this.entryUnitPrice = entryUnitPrice;
        this.entryProfitPercentage = entryProfitPercentage;
        this.quantity = quantity;
        this.batch = batch;
        this.proofOfPayment = proofOfPayment;
        this.sanitaryRegister = sanitaryRegister;
        this.arrivalDate = arrivalDate;
        this.expiryDate = expiryDate;
        this.lastUpdate = lastUpdate;
    }

    public int getEntryID() {
        return entryID;
    }

    public void setEntryID(int entryID) {
        this.entryID = entryID;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public double getEntryUnitPrice() {
        return entryUnitPrice;
    }

    public void setEntryUnitPrice(double entryUnitPrice) {
        this.entryUnitPrice = entryUnitPrice;
    }

    public double getEntryProfitPercentage() {
        return entryProfitPercentage;
    }

    public void setEntryProfitPercentage(double entryProfitPercentage) {
        this.entryProfitPercentage = entryProfitPercentage;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public ProofOfPayment getProofOfPayment() {
        return proofOfPayment;
    }

    public void setProofOfPayment(ProofOfPayment proofOfPayment) {
        this.proofOfPayment = proofOfPayment;
    }

    public String getSanitaryRegister() {
        return sanitaryRegister;
    }

    public void setSanitaryRegister(String sanitaryRegister) {
        this.sanitaryRegister = sanitaryRegister;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
    
    @Override
    public String toString() {
        return proofOfPayment.getNumber();
    }

}
