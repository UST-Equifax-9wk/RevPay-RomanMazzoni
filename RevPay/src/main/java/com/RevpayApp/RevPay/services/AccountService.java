package com.RevpayApp.RevPay.services;


import com.RevpayApp.RevPay.entities.*;
import com.RevpayApp.RevPay.exceptions.ObjectNotFoundException;
import com.RevpayApp.RevPay.repositories.AccountRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional(Transactional.TxType.REQUIRED)
public class AccountService {
    private final AccountRepository accountRepository;
    private final CardService cardService;
    private final TransactionService transactionService;
    private final LoanService loanService;
    private final InvoiceService invoiceService;


    @Autowired
    public AccountService(AccountRepository accountRepository, CardService cardService, TransactionService transactionService, LoanService loanService, InvoiceService invoiceService) {
        this.accountRepository = accountRepository;
        this.cardService = cardService;
        this.transactionService = transactionService;
        this.loanService = loanService;
        this.invoiceService = invoiceService;
    }

    public Account getAccountByAccountId(int id) throws ObjectNotFoundException {
        Optional<Account> a = accountRepository.findById(id);
        if(a.isEmpty())
            throw new ObjectNotFoundException("Could not find an account with id: " + id);
        return a.get();
    }

    public Set<Card> getCardsForAccount(Account a){
        return cardService.findAllCardsForAccount(a);
    }
    public Set<Transaction> getTransactionsForAccount(Account a){return transactionService.findAllTransactionsForAccount(a); }
    public Set<Loan> getLoansForAccount(Account a){ return loanService.findAllLoansForAccount(a);}
    public Set<BusinessInvoice> getInvoicesForAccount(Account a){ return invoiceService.findAllInvoicesByAccount(a);}

    public Account createNewAccount(Account a){
        return accountRepository.save(a);
    }

    public List<Account> getAllAccounts(){
        return accountRepository.findAll();
    }
}
