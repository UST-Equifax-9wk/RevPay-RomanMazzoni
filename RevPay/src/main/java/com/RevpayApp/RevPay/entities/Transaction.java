package com.RevpayApp.RevPay.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "Transactions")
public class Transaction {
    //AccountId TransactionId TransactionDetails TransactionAmount

    @Column(name = "Account Id")
    private int accountId;

    @Id
    @Column(name = "Transaction Id")
    private int transactionId;

    @Column(name = "Transaction Details")
    private String transactionDetails;

    @Column(name = "Transaction Amount")
    private float transactionAmount;

    public Transaction(int a, int t, String td, float ta){
        accountId =a;
        transactionId = t;
        transactionDetails = td;
        transactionAmount = ta;
    }

    public Transaction() {

    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public String getTransactionDetails() {
        return transactionDetails;
    }

    public void setTransactionDetails(String transactionDetails) {
        this.transactionDetails = transactionDetails;
    }

    public float getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(float transactionAmount) {
        this.transactionAmount = transactionAmount;
    }
}
