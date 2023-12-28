package com.RevpayApp.RevPay.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity(name = "BusinessInvoices")
public class BusinessInvoice {
    //invoiceId InvoiceDetails Amount

    @Id
    @Column(name = "Invoice Id")
    private int invoiceId;

    @Column(name = "Invoice Details")
    private String invoiceDetails;

    @Column(name = "Invoice Amount")
    private float amount = 0;

    @ManyToOne
    @JoinColumn(name = "Account Id")
    @JsonBackReference
    private Account account;
    public BusinessInvoice(int a, String i, float am){
        invoiceId = a;
        invoiceDetails = i;
        amount = am;
    }

    public BusinessInvoice() {

    }

    public int getinvoiceId() {
        return invoiceId;
    }

    public void setinvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
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
