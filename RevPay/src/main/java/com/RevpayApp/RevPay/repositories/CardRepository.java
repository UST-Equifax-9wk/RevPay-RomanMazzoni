package com.RevpayApp.RevPay.repositories;

import com.RevpayApp.RevPay.entities.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface CardRepository extends JpaRepository<Card, Integer> {
    Set<Card> findCardsByAccount_Id(Integer id);
}
