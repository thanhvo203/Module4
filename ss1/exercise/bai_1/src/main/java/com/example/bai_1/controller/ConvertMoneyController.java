package com.example.bai_1.controller;

import com.example.bai_1.service.impl.ConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/calculator")
public class ConvertMoneyController {
    @Autowired
    private ConvertService convertService;

    @PostMapping("/convert")
    public String calculator (@RequestParam("usd") int money, @RequestParam("exchangeRate") int exchange , Model model){
        int result = convertService.changeMoney(money,exchange);
        if(result == -1){
            model.addAttribute("error","Please input USD >= 0");
        }else{
            model.addAttribute("result", result);
        }
        return "/calculator";
    }
    @GetMapping()
    public String convert (){
        return "/calculator";
    }
}
