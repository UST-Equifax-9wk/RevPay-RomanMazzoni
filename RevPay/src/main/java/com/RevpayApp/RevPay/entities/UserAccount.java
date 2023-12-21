package com.RevpayApp.RevPay.entities;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;
import java.util.Set;

@Entity(name = "Users")
public class UserAccount {
    //AccountId Username Password email phone-number
    @Id
    @Column(name = "Account Id")
    private int accountId;

    @Column(name = "Username", unique = true)
    private String username;

    @Column(name = "Password")
    private String password;

    @Column(name = "Email", unique = true)
    private String email;

    @Column(name = "Phone Number", unique = true)
    private String phoneNumber;

    @OneToOne
    @MapsId
    @JoinColumn(name = "Account Id")
    private Account account;

    public UserAccount(int i, String u, String p, String e, String pn){
        accountId = i;
        username = u;
        password = p;
        email = e;
        phoneNumber = pn;
    }

    public UserAccount() {

    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
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
}
