package com.RevpayApp.RevPay.controllers;

import com.RevpayApp.RevPay.entities.Account;
import com.RevpayApp.RevPay.entities.Card;
import com.RevpayApp.RevPay.exceptions.DuplicateKeyException;
import com.RevpayApp.RevPay.exceptions.ObjectNotFoundException;
import com.RevpayApp.RevPay.services.AccountService;
import com.RevpayApp.RevPay.services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class CardController {
    private final CardService cardService;
    private final AccountService accountService;

    @Autowired
    public CardController(CardService cardService, AccountService accountService) {
        this.cardService = cardService;
        this.accountService = accountService;
    }

    @PostMapping(path = "/Accounts/{username}/addCard")
    public Card addCardToAccount(@PathVariable String username, @RequestBody Card card) throws ObjectNotFoundException, DuplicateKeyException {
        Account account = accountService.getAccountByUsername(username);
        card.setAccount(account);
        return cardService.saveCard(card, username);
    }

    @ExceptionHandler(ObjectNotFoundException.class)
    public String accountNotFoundExceptionHandler() {
        return "Cannot find account";
    }


    @ExceptionHandler(DuplicateKeyException.class)
    public String duplicateKeyException() {
        return "Your account already has that card registered!";
    }
}


