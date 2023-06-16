package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public interface ICalculatorService {
    String calculate (String calculate,double num1, double num2);
}
