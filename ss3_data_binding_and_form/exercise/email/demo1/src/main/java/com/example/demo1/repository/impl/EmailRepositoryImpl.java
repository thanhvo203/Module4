package com.example.demo1.repository.impl;

import com.example.demo1.model.Email;
import com.example.demo1.repository.IEmailRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmailRepositoryImpl implements IEmailRepository {

    private static List<String> languagesList = new ArrayList<>();
    private static List<Integer> sizeList = new ArrayList<>();
    static {
        languagesList.add("English");
        languagesList.add("Vietnamese");
        languagesList.add("Japanese");
        languagesList.add("Chinese");
        sizeList.add(5);
        sizeList.add(10);
        sizeList.add(15);
        sizeList.add(25);
        sizeList.add(50);
        sizeList.add(100);
    }
    @Override
    public List<String> getLanguages() {
        return languagesList;
    }

    @Override
    public List<Integer> getSize() {
        return sizeList;
    }

    @Override
    public Email getEmail() {
        Email email = new Email(languagesList.get(0),sizeList.get(2),false,"Thor");
        return email;
    }
}
