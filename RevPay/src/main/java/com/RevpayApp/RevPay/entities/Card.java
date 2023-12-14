package com.RevpayApp.RevPay.entities;


import jakarta.persistence.*;

@Entity(name = "Credit and Debit cards")
public class Card {
    //AccountId CardType CardNumber SecurityCode Expiration Zipcode


    @Column(name = "AccountId")
    private int accountId;

    @Id
    @Column(name = "Card Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cardId;

    @Column(name = "Credit/Debit")
    private String cardType;

    @Column(name = "Card Number")
    private String cardNumber;

    @Column(name = "Security Code")
    private String securityCode;

    @Column(name = "Card Expiration")
    private String expirationDate;

    @Column(name = "Zipcode")
    private String zipcode;

    public Card(int a, String ct, String cn, String s, String e, String z){
        accountId =a;
        cardType = ct;
        cardNumber = cn;
        securityCode = s;
        expirationDate = e;
        zipcode = z;
    }

    public Card() {

    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
}
