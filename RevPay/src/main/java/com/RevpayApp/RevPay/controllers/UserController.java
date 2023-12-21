package com.RevpayApp.RevPay.controllers;

import com.RevpayApp.RevPay.entities.UserAccount;
import com.RevpayApp.RevPay.services.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    private final UserAccountService userAccountService;
    @Autowired
    public UserController(UserAccountService userAccountService){
        this.userAccountService = userAccountService;
    }


    @CrossOrigin
    @PostMapping(path = "/userAccounts")
    @ResponseStatus(HttpStatus.OK)
    UserAccount registerUserAccount(@RequestBody UserAccount userAccount){
        return userAccountService.createNewUser(userAccount);
    }

}
