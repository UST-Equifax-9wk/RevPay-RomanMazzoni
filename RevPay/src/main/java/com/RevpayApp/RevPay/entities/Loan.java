package com.RevpayApp.RevPay.entities;

import jakarta.persistence.*;

@Entity(name = "Business loans")
public class Loan {
    //AccountId distributer Amountremaining interest initialloan initialdate


    @Column(name = "Account Id")
    private int accountId;

    @Id
    @Column(name = "Loan Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int loanId;

    @Column(name = "Distributer")
    private String distributer;

    @Column(name = "Remaining Total")
    private float remainingTotal;

    @Column(name = "Interest")
    private float interest;

    @Column(name = "Initial Amount")
    private float initialAmount;

    @Column(name = "Loan Start Date")
    private String loanStartDate;

    public Loan(int a, int l, String d, float ia, float i, String ls){
        accountId = a;
        loanId = l;
        distributer =d;
        remainingTotal = ia;
        interest = i;
        initialAmount = ia;
        loanStartDate = ls;
    }

    public Loan() {

    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getLoanId() {
        return loanId;
    }

    public void setLoanId(int loanId) {
        this.loanId = loanId;
    }

    public String getDistributer() {
        return distributer;
    }

    public void setDistributer(String distributer) {
        this.distributer = distributer;
    }

    public float getRemainingTotal() {
        return remainingTotal;
    }

    public void setRemainingTotal(float remainingTotal) {
        this.remainingTotal = remainingTotal;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public float getInitialAmount() {
        return initialAmount;
    }

    public void setInitialAmount(float initialAmount) {
        this.initialAmount = initialAmount;
    }

    public String getLoanStartDate() {
        return loanStartDate;
    }

    public void setLoanStartDate(String loanStartDate) {
        this.loanStartDate = loanStartDate;
    }

    public void changeRemainingTotal(float change){
        remainingTotal = remainingTotal + change;
    }
}
