package com.RevpayApp.RevPay.services;


import com.RevpayApp.RevPay.entities.BusinessAccount;
import com.RevpayApp.RevPay.entities.BusinessInvoice;
import com.RevpayApp.RevPay.repositories.AccountRepository;
import com.RevpayApp.RevPay.repositories.BusinessAccountRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional(Transactional.TxType.REQUIRED)
public class BusinessAccountService {
    private final AccountRepository accountRepository;
    private final BusinessAccountRepository businessAccountRepository;

    @Autowired
    public BusinessAccountService(AccountRepository accountRepository, BusinessAccountRepository businessAccountRepository){
        this.accountRepository = accountRepository;
        this.businessAccountRepository = businessAccountRepository;
    }

    public BusinessAccount getBAccountById(int id){
        Optional<BusinessAccount> ba = businessAccountRepository.findById(id);

        return ba.get();
    }

    public void delBAccount(int id){
        businessAccountRepository.deleteById(id);
    }
}
