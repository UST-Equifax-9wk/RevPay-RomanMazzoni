package com.RevpayApp.RevPay.services;


import com.RevpayApp.RevPay.entities.Account;
import com.RevpayApp.RevPay.entities.Transaction;
import com.RevpayApp.RevPay.repositories.AccountRepository;
import com.RevpayApp.RevPay.repositories.TransactionRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Transactional(Transactional.TxType.REQUIRED)
public class TransactionService {
    private final AccountRepository accountRepository;
    private final TransactionRepository TransactionRepository;

    public TransactionService(AccountRepository accountRepository, TransactionRepository TransactionRepository) {
        this.accountRepository = accountRepository;
        this.TransactionRepository = TransactionRepository;
    }
    public Transaction saveTransaction(Transaction Transaction, int ai){
        Account a = accountRepository.findById(ai).get();
        Transaction.setAccount(a);
        return TransactionRepository.save(Transaction);
    }
    public Set<Transaction> findAllTransactionsForAccount(Account a){
        return TransactionRepository.findTransactionsByAccount_Id(a.getId());
    }

    public Transaction updateTransaction(Transaction Transaction){
        return TransactionRepository.save(Transaction);
    }
}
