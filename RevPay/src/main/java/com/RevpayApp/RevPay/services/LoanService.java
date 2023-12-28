package com.RevpayApp.RevPay.services;

import com.RevpayApp.RevPay.entities.Account;
import com.RevpayApp.RevPay.entities.Loan;
import com.RevpayApp.RevPay.repositories.AccountRepository;
import com.RevpayApp.RevPay.repositories.LoanRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Transactional(Transactional.TxType.REQUIRED)
public class LoanService {
    private final AccountRepository accountRepository;
    private final LoanRepository loanRepository;

    @Autowired
    public LoanService(AccountRepository accountRepository, LoanRepository loanRepository) {
        this.accountRepository = accountRepository;
        this.loanRepository = loanRepository;
    }

    public Set<Loan> findAllLoansForAccount(Account a){return loanRepository.getLoansByAccount_Id(a.getId());}
}
