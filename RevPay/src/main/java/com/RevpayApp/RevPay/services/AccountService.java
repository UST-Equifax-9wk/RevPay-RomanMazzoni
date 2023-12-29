package com.RevpayApp.RevPay.services;


import com.RevpayApp.RevPay.entities.*;
import com.RevpayApp.RevPay.exceptions.DuplicateKeyException;
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
    public Account getAccountByUsername(String un) throws ObjectNotFoundException {
        Optional<Account> a = accountRepository.findAccountByUsername(un);
        if(a.isEmpty())
            throw new ObjectNotFoundException("Could not find an account with username: " + un);
        return a.get();
    }
    public Account getAccountByEmail(String e) throws ObjectNotFoundException {
        Optional<Account> a = accountRepository.findAccountByEmail(e);
        if(a.isEmpty())
            throw new ObjectNotFoundException("Could not find an account with email: " + e);
        return a.get();
    }
    public Account getAccountByPhonenumber(String pn) throws ObjectNotFoundException {
        Optional<Account> a = accountRepository.findAccountByPhoneNumber(pn);
        if(a.isEmpty())
            throw new ObjectNotFoundException("Could not find an account with phone number: " + pn);
        return a.get();
    }

    public Set<Card> getCardsForAccount(Account a){
        return cardService.findAllCardsForAccount(a);
    }
    public Set<Transaction> getTransactionsForAccount(Account a){return transactionService.findAllTransactionsForAccount(a); }
    public Set<Loan> getLoansForAccount(Account a){ return loanService.findAllLoansForAccount(a);}
    public Set<BusinessInvoice> getInvoicesForAccount(Account a){ return invoiceService.findAllInvoicesByAccount(a);}

    public Account createNewAccount(Account a) throws DuplicateKeyException {
        Optional<Account> a2 = accountRepository.findAccountByUsername(a.getUsername());
        if(!a2.isEmpty())
            if(a2.get().getId() != a.getId())
                throw new DuplicateKeyException("There is already an account with the username: " +a.getUsername());
        a2 = accountRepository.findAccountByEmail(a.getEmail());
        if(!a2.isEmpty())
            if(a2.get().getId() != a.getId())
                throw new DuplicateKeyException("There is already an account with the email: " +a.getEmail());
        a2 = accountRepository.findAccountByPhoneNumber(a.getPhoneNumber());
        if(!a2.isEmpty())
            if(a2.get().getId() != a.getId())
                throw new DuplicateKeyException("There is already an account with the phone number: " +a.getPhoneNumber());

        return accountRepository.save(a);
    }

    public List<Account> getAllAccounts(){
        return accountRepository.findAll();
    }
}
