package com.RevpayApp.RevPay.services;

import com.RevpayApp.RevPay.entities.Account;
import com.RevpayApp.RevPay.entities.BusinessInvoice;
import com.RevpayApp.RevPay.repositories.AccountRepository;
import com.RevpayApp.RevPay.repositories.BusinessAccountRepository;
import com.RevpayApp.RevPay.repositories.InvoiceRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Transactional(Transactional.TxType.REQUIRED)
public class InvoiceService {
    private final AccountRepository accountRepository;
    private final InvoiceRepository invoiceRepository;


    @Autowired
    public InvoiceService(AccountRepository accountRepository, InvoiceRepository invoiceRepository) {
        this.accountRepository = accountRepository;
        this.invoiceRepository = invoiceRepository;
    }
    public Set<BusinessInvoice> findAllInvoicesByAccount(Account a){
        return invoiceRepository.findBusinessInvoiceByAccount_AccountId(a.getId());
    }
}
