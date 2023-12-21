package com.RevpayApp.RevPay.services;


import com.RevpayApp.RevPay.entities.Account;
import com.RevpayApp.RevPay.entities.Card;
import com.RevpayApp.RevPay.exceptions.ObjectNotFoundException;
import com.RevpayApp.RevPay.repositories.AccountRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
@Transactional(Transactional.TxType.REQUIRED)
public class AccountService {
    private final AccountRepository accountRepository;
    private final CardService cardService;


    @Autowired
    public AccountService(AccountRepository accountRepository, CardService cardService) {
        this.accountRepository = accountRepository;
        this.cardService = cardService;
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
}
