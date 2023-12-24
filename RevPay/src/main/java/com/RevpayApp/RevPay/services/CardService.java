package com.RevpayApp.RevPay.services;

import com.RevpayApp.RevPay.entities.Account;
import com.RevpayApp.RevPay.entities.Card;
import com.RevpayApp.RevPay.repositories.AccountRepository;
import com.RevpayApp.RevPay.repositories.CardRepository;
import com.RevpayApp.RevPay.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Transactional(Transactional.TxType.REQUIRED)
public class CardService {
    private final AccountRepository accountRepository;
    private final CardRepository cardRepository;

    public CardService(AccountRepository accountRepository, CardRepository cardRepository) {
        this.accountRepository = accountRepository;
        this.cardRepository = cardRepository;
    }
    public Card saveCard(Card card, int ai){
        Account a = accountRepository.findById(ai).get();
        card.setAccount(a);
        return cardRepository.save(card);
    }
    public Set<Card> findAllCardsForAccount(Account a){
        return cardRepository.findCardsByAccount_Id(a.getId());
    }

    public Card updateCard(Card card){
        return cardRepository.save(card);
    } //this works

}
