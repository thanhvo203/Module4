package com.example.demo1.repository;

import com.example.demo1.model.Email;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEmailRepository {
    List<String> getLanguages();
    List<Integer> getSize();

    Email getEmail();
}
