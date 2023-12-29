package com.RevpayApp.RevPay.services;


import com.RevpayApp.RevPay.entities.UserAccount;
import com.RevpayApp.RevPay.exceptions.ObjectNotFoundException;
import com.RevpayApp.RevPay.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

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
    public UserAccount getByUsername(String un) throws ObjectNotFoundException {
        Optional<UserAccount> ua = userRepository.findByUsername(un);
        if (ua.isEmpty())
            throw new ObjectNotFoundException("Could not find a user with the user name: " + un);
        return ua.get();
    }
    public UserAccount getByEmail(String e) throws ObjectNotFoundException {
        Optional<UserAccount> ua = userRepository.findByEmail(e);
        if (ua.isEmpty())
            throw new ObjectNotFoundException("Could not find a user with the email: " + e);
        return ua.get();
    }
    public UserAccount getByPhoneNumber(String pn) throws ObjectNotFoundException {
        Optional<UserAccount> ua = userRepository.findByPhoneNumber(pn);
        if (ua.isEmpty())
            throw new ObjectNotFoundException("Could not find a user with the phone number: " + pn);
        return ua.get();
    }
    public UserAccount createNewUser(UserAccount ua){



        return userRepository.save(ua);
    }

    public List<UserAccount> getAllUsers(){
        return userRepository.findAll();
    }


    public UserAccount getByAccountID(int id) throws ObjectNotFoundException {
        Optional<UserAccount> ua = userRepository.findById(id);
        if(ua.isEmpty())
            throw new ObjectNotFoundException("Could not find a user with the id: " +id);
        return ua.get();
    }

}
