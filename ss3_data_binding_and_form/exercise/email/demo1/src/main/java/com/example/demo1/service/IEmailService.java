package com.example.demo1.service;

import com.example.demo1.model.Email;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IEmailService {
    List<String> getLanguages();
    List<Integer> getSize();

    Email getEmail();
}
