package com.RevpayApp.RevPay.repositories;

import com.RevpayApp.RevPay.entities.BusinessInvoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface InvoiceRepository extends JpaRepository<BusinessInvoice, Integer> {
    public Set<BusinessInvoice> findBusinessInvoiceByAccount_AccountId(Integer i);
}
