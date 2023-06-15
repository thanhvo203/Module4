package com.example.bai_1.service.impl;

import com.example.bai_1.service.IConvertService;
import org.springframework.stereotype.Service;

@Service
public class ConvertService implements IConvertService {
    @Override
    public int changeMoney(int money, int exchange) {
        if(money < 0){
            return 0;
        }
        return money*exchange;
    }
}
