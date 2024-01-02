package com.RevpayApp.RevPay.controllers;


import com.RevpayApp.RevPay.entities.Account;
import com.RevpayApp.RevPay.exceptions.DuplicateKeyException;
import com.RevpayApp.RevPay.exceptions.ObjectNotFoundException;
import com.RevpayApp.RevPay.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(path = "/Accounts")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class AccountController {
    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping (path = "")
    public Account registerAccount(@RequestBody Account account) throws DuplicateKeyException {
        return accountService.createNewAccount(account);
    }

    @GetMapping(path = "")
    public List<Account> getAllAccounts(){
        return accountService.getAllAccounts();
    }

    @PostMapping(path = "/updateBalance")
    public float updateAccountBalance(@RequestBody Account account){
        return accountService.updateInfoForAccount(account);
    }

    @GetMapping(path = "/username/{username}")
    public Account getAccountByUsername(@PathVariable String username) throws ObjectNotFoundException { return accountService.getAccountByUsername(username);}

    @GetMapping(path = "/email/{email}")
    public Account getAccountByEmail(@PathVariable String email) throws ObjectNotFoundException { return accountService.getAccountByEmail(email);}

    @GetMapping(path = "/phoneNumber/{phoneNumber}")
    public Account getAccountByPhoneNumber(@PathVariable String phoneNumber) throws ObjectNotFoundException { return accountService.getAccountByPhonenumber(phoneNumber);}


    @ExceptionHandler(DuplicateKeyException.class)
@   ResponseStatus(HttpStatus.BAD_REQUEST)
    public String duplicateKeyExceptionHandler(){return "That username/email/phone number is already in use!";}

}
