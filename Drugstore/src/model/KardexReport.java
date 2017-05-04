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
public class KardexReport {

    private String date;
    private String description;
    private String detail;
    private String entryQuantity;
    private String entryPrice;
    private String saleQuantity;
    private String salePrice;
    private String amount;

    public KardexReport() {
        entryQuantity = "";
        entryPrice = "";
        saleQuantity = "";
        salePrice = "";
        
    }

    public KardexReport(String date, String description, String detail, String entryQuantity, String entryPrice, String saleQuantity, String salePrice, String amount) {
        this.date = date;
        this.description = description;
        this.detail = detail;
        this.entryQuantity = entryQuantity;
        this.entryPrice = entryPrice;
        this.saleQuantity = saleQuantity;
        this.salePrice = salePrice;
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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

    public String getEntryQuantity() {
        return entryQuantity;
    }

    public void setEntryQuantity(String entryQuantity) {
        this.entryQuantity = entryQuantity;
    }

    public String getEntryPrice() {
        return entryPrice;
    }

    public void setEntryPrice(String entryPrice) {
        this.entryPrice = entryPrice;
    }

    public String getSaleQuantity() {
        return saleQuantity;
    }

    public void setSaleQuantity(String saleQuantity) {
        this.saleQuantity = saleQuantity;
    }

    public String getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(String salePrice) {
        this.salePrice = salePrice;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

}
