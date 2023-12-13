package com.RevpayApp.RevPay.entities;

import jakarta.persistence.*;

@Entity(name = "Accounts")
public class Account {
    @Id
    @Column(name = "AccountId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer accountId;

    //AccountId AccountType
    @Column(name = "AccountType") //BUISINESS OR USER
    private String accountType;


    public Account(String accountType){

        this.accountType = accountType;
    }

    public Account() {

    }

    public void setId(Integer id) {
        this.accountId = id;
    }

    public Integer getId() {
        return accountId;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
}
