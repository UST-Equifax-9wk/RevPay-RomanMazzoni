package com.RevpayApp.RevPay.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.util.Set;

@Entity(name = "Accounts")
public class Account {
    @Id
    @Column(name = "AccountId")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer accountId;

    //AccountId AccountType
    @Column(name = "AccountType") //BUISINESS OR USER
    private Boolean accountBusiness;


    @Column(name = "balance")
    private float balance = 0;

    @Column(name = "Username", unique = true)
    private String username;

    @Column(name = "Password")
    private String password;

    @Column(name = "Email", unique = true)
    private String email;

    @Column(name = "PhoneNumber", unique = true)
    private String phoneNumber;
    public Account(boolean accountType){
        this.accountBusiness = accountType;
    }
    public Account(int id, String username, String password){
        this.accountId = id;
        this.username = username;
        this.password = password;
    }





    @OneToMany(mappedBy = "account", cascade = CascadeType.PERSIST)
    @JsonManagedReference
    private Set<BusinessInvoice> invoices;

    @OneToMany(mappedBy = "account", cascade = CascadeType.PERSIST)
    @JsonManagedReference
    private Set<Loan> loans;

    @OneToMany(mappedBy = "account", cascade = CascadeType.PERSIST)
    @JsonManagedReference
    private Set<Transaction> transactions;

    @OneToMany(mappedBy = "account", cascade = CascadeType.PERSIST)
    @JsonManagedReference
    private Set<Card> cards;

    public Account() {

    }


    public void setId(Integer id) {
        this.accountId = id;
    }

    public Integer getId() {
        return accountId;
    }


    public void changeBalance(float change){
        balance = balance + change;
    }

    public Boolean getAccountBusiness() {
        return accountBusiness;
    }

    public void setAccountBusiness(Boolean accountBusiness) {
        this.accountBusiness = accountBusiness;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }
}
