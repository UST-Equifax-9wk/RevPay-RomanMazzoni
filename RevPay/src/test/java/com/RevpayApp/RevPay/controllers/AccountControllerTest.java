package com.RevpayApp.RevPay.controllers;

import com.RevpayApp.RevPay.entities.Account;
import com.RevpayApp.RevPay.entities.UserAccount;
import com.RevpayApp.RevPay.services.AccountService;
import com.RevpayApp.RevPay.services.UserAccountService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.mockito.Mockito.when;

@WebMvcTest(AccountController.class)
public class AccountControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AccountService accountService;

    @Test
    void test() throws Exception{
        int accId = 1;
        Account testA = new Account(accId, "username", "password");
        when(accountService.getAccountByAccountId(accId)).thenReturn(testA);

        this.mockMvc.perform(get("/Accounts/accountid/" + accId)).andDo(print()).andExpect(status().isOk());
    }
}