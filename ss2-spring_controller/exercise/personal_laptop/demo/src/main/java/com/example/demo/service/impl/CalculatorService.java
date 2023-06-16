package com.example.demo.service.impl;

import com.example.demo.service.ICalculatorService;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements ICalculatorService {


    @Override
    public String calculate(String calculate, double num1, double num2) {
        String result = "";
        switch (calculate) {
            case "addition":
                result = String.valueOf(num1 + num2);
                break;
            case "subtraction":
                result = String.valueOf(num1 - num2);
                break;
            case "multiply":
                result = String.valueOf(num1 * num2);
                break;
            case "division":
                if(num2 == 0){
                    result = "Can not division by 0";
                }else{
                    result = String.valueOf(num1 / num2);
                }
                break;
        }
        return result;
    }
}
