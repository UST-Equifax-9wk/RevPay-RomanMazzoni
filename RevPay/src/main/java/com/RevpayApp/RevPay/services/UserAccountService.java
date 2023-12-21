package com.RevpayApp.RevPay.services;


import com.RevpayApp.RevPay.entities.UserAccount;
import com.RevpayApp.RevPay.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional(Transactional.TxType.REQUIRED)
public class UserAccountService {
    private final UserRepository userRepository;

    @Autowired
    public UserAccountService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public void addNewUser(UserAccount ua){
        userRepository.save(ua);
    }
    public UserAccount getByUsername(String un){
        Optional<UserAccount> ua = userRepository.findByUsername(un);
        return ua.get();
    }
    public UserAccount getByEmail(String e){
        Optional<UserAccount> ua = userRepository.findByEmail(e);
        return ua.get();
    }
    public UserAccount getByPhoneNumber(String pn){
        Optional<UserAccount> ua = userRepository.findByPhoneNumber(pn);
        return ua.get();
    }
    public UserAccount createNewUser(UserAccount ua){
        return userRepository.save(ua);
    }

}
