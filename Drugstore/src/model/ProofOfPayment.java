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
public class ProofOfPayment {

    private int proofOfPaymentID;
    private String number;
    private String type;
    private int active;
    private Date lastUpdate;

    public ProofOfPayment() {
    }

    public ProofOfPayment(String number, String type) {
        this.number = number;
        this.type = type;
    }

    public ProofOfPayment(int proofOfPaymentID, String number, String type) {
        this.proofOfPaymentID = proofOfPaymentID;
        this.number = number;
        this.type = type;
    }

    public ProofOfPayment(int proofOfPaymentID, String number, String type, int active, Date lastUpdate) {
        this.proofOfPaymentID = proofOfPaymentID;
        this.number = number;
        this.type = type;
        this.active = active;
        this.lastUpdate = lastUpdate;
    }

    public int getProofOfPaymentID() {
        return proofOfPaymentID;
    }

    public void setProofOfPaymentID(int proofOfPaymentID) {
        this.proofOfPaymentID = proofOfPaymentID;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString() {
        return number;
    }

}
