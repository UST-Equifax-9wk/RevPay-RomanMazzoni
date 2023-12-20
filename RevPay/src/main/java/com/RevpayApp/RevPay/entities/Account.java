package com.RevpayApp.RevPay.entities;

import jakarta.persistence.*;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.util.Set;

@Entity(name = "Accounts")
public class Account {
    @Id
    @Column(name = "AccountId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer accountId;

    //AccountId AccountType
    @Column(name = "AccountType") //BUISINESS OR USER
    private String accountType;

    @Column(name = "balance")
    private float balance = 0;
    public Account(String accountType){

        this.accountType = accountType;
    }

    @OneToOne(mappedBy = "account", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private UserAccount userAccount;

    @OneToOne(mappedBy = "account", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private BusinessAccount businessAccount;

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

    public void changeBalance(float change){
        balance = balance + change;
    }
}
