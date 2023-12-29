package com.RevpayApp.RevPay.repositories;

import com.RevpayApp.RevPay.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
    Optional<Account> findAccountByUsername(String un);
    Optional<Account> findAccountByPhoneNumber(String pn);
    Optional<Account> findAccountByEmail(String e);

}
