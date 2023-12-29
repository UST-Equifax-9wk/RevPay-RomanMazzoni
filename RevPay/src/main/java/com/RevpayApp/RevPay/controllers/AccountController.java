package com.RevpayApp.RevPay.controllers;


import com.RevpayApp.RevPay.entities.Account;
import com.RevpayApp.RevPay.exceptions.DuplicateKeyException;
import com.RevpayApp.RevPay.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class AccountController {
    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping (path = "/Accounts")
    public Account registerAccount(@RequestBody Account account) throws DuplicateKeyException {
        return accountService.createNewAccount(account);
    }

    @GetMapping(path = "/Accounts")
    public List<Account> getAllAccounts(){
        return accountService.getAllAccounts();
    }


}
