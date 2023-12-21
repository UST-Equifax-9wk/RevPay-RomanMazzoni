package com.RevpayApp.RevPay.repositories;


import com.RevpayApp.RevPay.entities.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Set;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Integer> {

}
