package com.RevpayApp.RevPay.controllers;

import com.RevpayApp.RevPay.entities.Account;
import com.RevpayApp.RevPay.entities.Card;
import com.RevpayApp.RevPay.entities.Loan;
import com.RevpayApp.RevPay.exceptions.DuplicateKeyException;
import com.RevpayApp.RevPay.exceptions.ObjectNotFoundException;
import com.RevpayApp.RevPay.services.AccountService;
import com.RevpayApp.RevPay.services.LoanService;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@CrossOrigin(allowCredentials = "true", origins = "http://localhost:4200")
public class LoanController {
    private final LoanService loanService;
    private final AccountService accountService;


    public LoanController(LoanService loanService, AccountService accountService) {
        this.loanService = loanService;
        this.accountService = accountService;
    }

    @PostMapping(path = "/Accounts/{username}/addLoanRequest")
    public Loan addCardToAccount(@PathVariable String username, @RequestBody Loan loan) throws ObjectNotFoundException, DuplicateKeyException {
        Account account = accountService.getAccountByUsername(username);
        loan.setAccount(account);
        return loanService.saveLoan(loan, username);
    }
    @GetMapping(path = "/Accounts/{username}/loans")
    public Set<Loan> getAllTransactionsForAccount(@PathVariable String username) throws ObjectNotFoundException {
        Account account = accountService.getAccountByUsername(username);
        return loanService.findAllLoansForAccount(account);
    }
}
