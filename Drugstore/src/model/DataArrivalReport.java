/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Sergio Pastor
 */
public class DataArrivalReport {

    private String arrivalDate;
    private String description;
    private String detail;
    private String proofOfPayment;
    private String type;
    private int quantity;
    private String batch;
    private String supplier;
    private String sanitaryRegister;
    private String expiryDate;

    public DataArrivalReport() {
    }

    public DataArrivalReport(String arrivalDate, String description, String detail, String proofOfPayment, String type, int quantity, String batch, String supplier, String sanitaryRegister, String expiryDate) {
        this.arrivalDate = arrivalDate;
        this.description = description;
        this.detail = detail;
        this.proofOfPayment = proofOfPayment;
        this.type = type;
        this.quantity = quantity;
        this.batch = batch;
        this.supplier = supplier;
        this.sanitaryRegister = sanitaryRegister;
        this.expiryDate = expiryDate;
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

    public String getProofOfPayment() {
        return proofOfPayment;
    }

    public void setProofOfPayment(String proofOfPayment) {
        this.proofOfPayment = proofOfPayment;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getSanitaryRegister() {
        return sanitaryRegister;
    }

    public void setSanitaryRegister(String sanitaryRegister) {
        this.sanitaryRegister = sanitaryRegister;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

}
