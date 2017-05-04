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
public class SaleProductDetail {

    private int saleProductID;
    private Sale sale;
    private Product product;
    private int quantity;
    private double salePrice;
    private double saleTotalPrice;
    private Date lastUpdate;

    public SaleProductDetail() {
    }

    public SaleProductDetail(Sale sale, Product product, int quantity, double salePrice, double saleTotalPrice) {
        this.sale = sale;
        this.product = product;
        this.quantity = quantity;
        this.salePrice = salePrice;
        this.saleTotalPrice = saleTotalPrice;
    }

    public SaleProductDetail(int saleProductID, Sale sale, Product product, int quantity, Date lastUpdate) {
        this.saleProductID = saleProductID;
        this.sale = sale;
        this.product = product;
        this.quantity = quantity;
        this.lastUpdate = lastUpdate;
    }

    public int getSaleProductID() {
        return saleProductID;
    }

    public void setSaleProductID(int saleProductID) {
        this.saleProductID = saleProductID;
    }

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    public double getSaleTotalPrice() {
        return saleTotalPrice;
    }

    public void setSaleTotalPrice(double saleTotalPrice) {
        this.saleTotalPrice = saleTotalPrice;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

}
