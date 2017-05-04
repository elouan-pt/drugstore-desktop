/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Usuario
 */
public class ProductArrivalReport {

    private String arrivalDate;
    private String description;
    private String detail;
    private double entryUnitPrice;
    private int quantity;
    private double amount;

    public ProductArrivalReport() {
    }

    public ProductArrivalReport(String arrivalDate, String description, String detail, double entryUnitPrice, int quantity, double amount) {
        this.arrivalDate = arrivalDate;
        this.description = description;
        this.detail = detail;
        this.entryUnitPrice = entryUnitPrice;
        this.quantity = quantity;
        this.amount = amount;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public double getEntryUnitPrice() {
        return entryUnitPrice;
    }

    public void setEntryUnitPrice(double entryUnitPrice) {
        this.entryUnitPrice = entryUnitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

}
