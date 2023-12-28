package com.RevpayApp.RevPay.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Set;

@Entity(name = "Business Accounts")
public class BusinessAccount {
    //AccountId username password email
    @Id
    @Column(name = "Account Id")
    private int accountId;

    @Column(name = "Username")
    private String username;

    @Column(name = "Password")
    private String password;

    @Column(name = "Email")
    private String email;








    public BusinessAccount(int a, String u, String p, String e){
        accountId = a;
        username = u;
        password = p;
        email = e;
    }

    public BusinessAccount() {

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
}
