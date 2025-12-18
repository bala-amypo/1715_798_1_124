package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.UserAccount;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.service.UserAccountService;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    @Autowired
    UserAccountRepository repo;

    @Override
    public UserAccount register(UserAccount user) {
        // mock encoding rule
        user.setPassword(user.getPassword() + "_ENC");
        return repo.save(user);
    }

    @Override
    public UserAccount findByEmailOrThrow(String email) {
        return repo.findAll()
                .stream()
                .filter(u -> email.equals(u.getEmail()))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }
}
