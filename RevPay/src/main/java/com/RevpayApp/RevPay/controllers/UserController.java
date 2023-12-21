package com.RevpayApp.RevPay.controllers;

import com.RevpayApp.RevPay.entities.UserAccount;
import com.RevpayApp.RevPay.exceptions.ObjectNotFoundException;
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

    @GetMapping(path = "/userAccounts/{username}")
    @ResponseStatus(HttpStatus.OK)
    UserAccount getUserByUsername(@PathVariable String username) throws ObjectNotFoundException{
        return userAccountService.getByUsername(username);
    }
    @GetMapping(path = "/userAccounts/{phoneNumber}")
    @ResponseStatus(HttpStatus.OK)
    UserAccount getUserByPhoneNumber(@PathVariable String phoneNumber) throws ObjectNotFoundException{
        return userAccountService.getByPhoneNumber(phoneNumber);
    }

    @GetMapping(path = "/userAccounts/{email}")
    @ResponseStatus(HttpStatus.OK)
    UserAccount getUserByEmail(@PathVariable String email) throws ObjectNotFoundException{
        return userAccountService.getByEmail(email);
    }

}
