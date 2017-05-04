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
public class Product {

    private int productID;
    private String description;
    private Form form;
    private double productUnitPrice;
    private double productProfitPercentage;
    private double salePrice;
    private int stock;
    private Date lastUpdate;

    public Product() {
    }

    public Product(String description, Form form, double productUnitPrice, double productProfitPercentage, double salePrice, int stock) {
        this.description = description;
        this.form = form;
        this.productUnitPrice = productUnitPrice;
        this.productProfitPercentage = productProfitPercentage;
        this.salePrice = salePrice;
        this.stock = stock;
    }

    public Product(int productID, String description, Form form, double productUnitPrice, double productProfitPercentage, int stock, Date lastUpdate) {
        this.productID = productID;
        this.description = description;
        this.form = form;
        this.productUnitPrice = productUnitPrice;
        this.productProfitPercentage = productProfitPercentage;
        this.stock = stock;
        this.lastUpdate = lastUpdate;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Form getForm() {
        return form;
    }

    public void setForm(Form form) {
        this.form = form;
    }

    public double getProductUnitPrice() {
        return productUnitPrice;
    }

    public void setProductUnitPrice(double productUnitPrice) {
        this.productUnitPrice = productUnitPrice;
    }

    public double getProductProfitPercentage() {
        return productProfitPercentage;
    }

    public void setProductProfitPercentage(double productProfitPercentage) {
        this.productProfitPercentage = productProfitPercentage;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString() {
        return description;
    }

}
