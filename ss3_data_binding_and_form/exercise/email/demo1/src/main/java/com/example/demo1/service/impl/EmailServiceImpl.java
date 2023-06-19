package com.example.demo1.service.impl;

import com.example.demo1.model.Email;
import com.example.demo1.repository.impl.EmailRepositoryImpl;
import com.example.demo1.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailServiceImpl implements IEmailService {
    @Autowired
    private EmailRepositoryImpl emailRepository;
    @Override
    public List<String> getLanguages() {
        return emailRepository.getLanguages();
    }

    @Override
    public List<Integer> getSize() {
        return emailRepository.getSize();
    }

    @Override
    public Email getEmail() {
        Email email = emailRepository.getEmail();
        return email;
    }

}
