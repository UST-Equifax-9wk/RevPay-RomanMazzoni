package com.RevpayApp.RevPay.repositories;

import com.RevpayApp.RevPay.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    Set<Transaction> getTransactionsByAccountId(int ai);
}
