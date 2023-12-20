package com.RevpayApp.RevPay.repositories;

import com.RevpayApp.RevPay.entities.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;
@Repository
public interface UserRepository extends JpaRepository<UserAccount, Integer> {
    Optional<UserAccount> findByUsername(String un);
    Optional<UserAccount> findByEmail(String e);
    Optional<UserAccount> findByPhoneNumber(String un);
}
