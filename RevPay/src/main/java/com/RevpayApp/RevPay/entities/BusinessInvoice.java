package com.RevpayApp.RevPay.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "BusinessInvoices")
public class BusinessInvoice {
    //AccountId InvoiceDetails Amount

    @Id
    @Column(name = "Account Id")
    private int accountId;

    @Column(name = "Invoice Details")
    private String invoiceDetails;

    @Column(name = "Invoice Amount")
    private float amount = 0;

    public BusinessInvoice(int a, String i, float am){
        accountId = a;
        invoiceDetails = i;
        amount = am;
    }

    public BusinessInvoice() {

    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getInvoiceDetails() {
        return invoiceDetails;
    }

    public void setInvoiceDetails(String invoiceDetails) {
        this.invoiceDetails = invoiceDetails;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
}
