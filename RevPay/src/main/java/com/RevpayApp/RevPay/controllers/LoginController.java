package com.RevpayApp.RevPay.controllers;


import com.RevpayApp.RevPay.entities.Account;
import com.RevpayApp.RevPay.exceptions.LoginNotSucessfulException;
import com.RevpayApp.RevPay.exceptions.ObjectNotFoundException;
import com.RevpayApp.RevPay.services.AccountService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(allowCredentials = "true", origins = "http://localhost:4200")
public class LoginController {
    private final AccountService accountService;

    public LoginController(AccountService accountService) {
        this.accountService = accountService;
    }


    @PostMapping(path = "/login")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Account authenticateAccount(@RequestBody Account account, HttpServletResponse response) throws LoginNotSucessfulException{
        if(accountService.authAccount(account)){
            try {
                Cookie cookie = new Cookie("username", account.getUsername());
                cookie.setMaxAge((60 * 60 * 24));
                cookie.setPath(("/"));
                response.addCookie(cookie);
                return accountService.getAccountByUsername(account.getUsername());
            }
            catch (ObjectNotFoundException e){
                throw new LoginNotSucessfulException("Creditials do not match");
            }
        }
        else{
            throw new LoginNotSucessfulException("Creditials do not match");
        }
    }
    @GetMapping(path = "/cookie-test")
    @ResponseStatus(HttpStatus.OK)
    public Account testCookie(@CookieValue(name = "username") String username) throws ObjectNotFoundException {//get cookie from request
        //System.out.println("cookie username: " + username);
        return accountService.getAccountByUsername(username);
    }


    @ExceptionHandler(LoginNotSucessfulException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public String loginUnsucessfulExceptionHandler() {return "Creditials do not match";}
}
