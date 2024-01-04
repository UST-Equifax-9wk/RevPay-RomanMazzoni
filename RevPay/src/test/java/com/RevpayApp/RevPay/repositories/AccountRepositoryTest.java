package com.RevpayApp.RevPay.repositories;


import com.RevpayApp.RevPay.entities.Account;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
public class AccountRepositoryTest {

    @Autowired
    AccountRepository sut;

    @Autowired
    TestEntityManager entityManager;

    @Test
    void test(){
        Account ta = new Account(5, "username", "password");
        sut.save(ta);
        Assertions.assertEquals(entityManager.find(Account.class, ta.getId()), ta);
    }
}
