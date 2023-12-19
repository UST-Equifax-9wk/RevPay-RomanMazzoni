package com.RevpayApp.RevPay.repositories;

import com.RevpayApp.RevPay.entities.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Set;
@Repository
public interface UserRepository extends JpaRepository<UserAccount, Integer> {
    Set<UserAccount> findUserByAccountId(Integer ai);
}
