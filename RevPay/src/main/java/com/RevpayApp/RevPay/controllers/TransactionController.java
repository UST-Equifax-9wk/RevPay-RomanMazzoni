package com.RevpayApp.RevPay.controllers;

import com.RevpayApp.RevPay.entities.Account;
import com.RevpayApp.RevPay.entities.Card;
import com.RevpayApp.RevPay.entities.Transaction;
import com.RevpayApp.RevPay.exceptions.DuplicateKeyException;
import com.RevpayApp.RevPay.exceptions.ObjectNotFoundException;
import com.RevpayApp.RevPay.services.AccountService;
import com.RevpayApp.RevPay.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class TransactionController {
    private final TransactionService transactionService;
    private final AccountService accountService;

    @Autowired
    public TransactionController(TransactionService transactionService, AccountService accountService) {
        this.transactionService = transactionService;
        this.accountService = accountService;
    }
    @PostMapping(path = "/Accounts/{username}/addTransaction")
    public Transaction addTransactionToAccount(@PathVariable String username, @RequestBody Transaction transaction) throws ObjectNotFoundException {
        Account account = accountService.getAccountByUsername(username);
        transaction.setAccount(account);
        return transactionService.saveTransaction(transaction, username);
    }
    @GetMapping(path = "/Accounts/{username}/transactions")
    public Set<Transaction> getAllTransactionsForAccount(@PathVariable String username) throws ObjectNotFoundException {
        Account account = accountService.getAccountByUsername(username);
        return transactionService.findAllTransactionsForAccount(account);
    }


    @ExceptionHandler(ObjectNotFoundException.class)
    public String accountNotFoundExceptionHandler() {
        return "Cannot find account, this shouldn't happen here";
    }



}
