package com.RevpayApp.RevPay.repositories;


import com.RevpayApp.RevPay.entities.Account;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.util.Assert;

@DataJpaTest
public class AccountRepositoryTest {

    @Autowired
    AccountRepository sut;

    @Autowired
    TestEntityManager entityManager;

    @Test
    void test(){
        Account ta = new Account(5, "username", "password");
        Account test2 = sut.save(ta);
        Assertions.assertThat(entityManager.find(Account.class, test2.getId()) ).isEqualTo(ta);
    }
}
