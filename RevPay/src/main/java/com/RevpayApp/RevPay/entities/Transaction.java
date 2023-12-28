package com.RevpayApp.RevPay.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity(name = "Transactions")
public class Transaction {
    //AccountId TransactionId TransactionDetails TransactionAmount


    @Id
    @Column(name = "Transaction Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int transactionId;


    @Column(name = "Transaction Details")
    private String transactionDetails;

    @Column(name = "Transaction Amount")
    private float transactionAmount;

    @ManyToOne
    @JoinColumn(name = "Account Id")
    @JsonBackReference
    private Account account;


    public Transaction(String td, float ta){
        transactionDetails = td;
        transactionAmount = ta;
    }
    public Transaction(String td, float ta, Account a){
        transactionDetails = td;
        transactionAmount = ta;
        account = a;
    }

    public Transaction() {

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

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

}
