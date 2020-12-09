package com.spring.boot.demo.SpringDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Account account = accountRepository.findByUsername(s);
        if(account == null){
            throw new UsernameNotFoundException("Can not find user with username: " + s);
        }
        return new CustomUserDetails(account);
    }

    public boolean checkLogin(Account account){
        if(account.getPassword().equals(accountRepository.findByUsername(account.getUsername()).getPassword())){
            return true;
        }
        return false;
    }
}
