package com.RevpayApp.RevPay.controllers;

import com.RevpayApp.RevPay.entities.UserAccount;
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

@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserAccountService userAccountService;

    @Test
    void test() throws Exception{
        Integer accId = 1;
        UserAccount testUA = new UserAccount(accId, "username", "password", "email", "pn");
        when(userAccountService.getByAccountID(accId)).thenReturn(testUA);

        this.mockMvc.perform(get("/userAccounts/" + accId)).andDo(print()).andExpect(status().isOk());
    }
}
