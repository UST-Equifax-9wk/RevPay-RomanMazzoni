package com.RevpayApp.RevPay.repositories;

import com.RevpayApp.RevPay.entities.BusinessAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface BusinessAccountRepository extends JpaRepository<BusinessAccount, Integer> {
    //Optional<BusinessAccount> getBusinessAccountByAccountId(int id);
}
