package com.RevpayApp.RevPay.services;

import com.RevpayApp.RevPay.entities.Account;
import com.RevpayApp.RevPay.entities.Card;
import com.RevpayApp.RevPay.repositories.CardRepository;
import com.RevpayApp.RevPay.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Transactional(Transactional.TxType.REQUIRED)
public class CardService {
    private final UserRepository userRepository;
    private final CardRepository cardRepository;

    public CardService(UserRepository userRepository, CardRepository cardRepository) {
        this.userRepository = userRepository;
        this.cardRepository = cardRepository;
    }

    public Set<Card> findAllCardsForAccount(Account a){
        return cardRepository.findCardsByAccount_Id(a.getId());
    }
}
