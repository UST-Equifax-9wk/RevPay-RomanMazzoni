package com.RevpayApp.RevPay.services;

import com.RevpayApp.RevPay.entities.Account;
import com.RevpayApp.RevPay.entities.Card;
import com.RevpayApp.RevPay.exceptions.DuplicateKeyException;
import com.RevpayApp.RevPay.exceptions.ObjectNotFoundException;
import com.RevpayApp.RevPay.repositories.AccountRepository;
import com.RevpayApp.RevPay.repositories.CardRepository;
import com.RevpayApp.RevPay.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;
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
    public Card saveCard(Card card, String ai) throws ObjectNotFoundException, DuplicateKeyException {
        Account a = accountRepository.findAccountByUsername(ai).get();
        card.setAccount(a);
        Optional<Card> c2 = cardRepository.findCardByCardNumber(card.getCardNumber());
        if(!c2.isEmpty())
            if(card.getAccount().equals(c2.get().getAccount()))
                throw new DuplicateKeyException("There is already a card in use with number: " +card.getCardNumber());
        return cardRepository.save(card);
    }
    public Card getCardbyCardNumber(String num) throws ObjectNotFoundException {
        Optional<Card> card = cardRepository.findCardByCardNumber(num);
        if (card.isEmpty())
            throw new ObjectNotFoundException("cannot find card");
        return card.get();
    }
    public Set<Card> findAllCardsForAccount(Account a){
        return cardRepository.findCardsByAccount_Id(a.getId());
    }

    public Card updateCard(Card card){
        return cardRepository.save(card);
    } //this works

}
