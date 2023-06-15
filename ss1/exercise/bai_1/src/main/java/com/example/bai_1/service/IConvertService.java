package com.example.bai_1.service;

import org.springframework.stereotype.Service;

@Service
public interface IConvertService {
    int changeMoney(int money , int exchange);
}
