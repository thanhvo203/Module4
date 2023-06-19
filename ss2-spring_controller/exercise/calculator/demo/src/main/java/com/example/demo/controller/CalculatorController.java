package com.example.demo.controller;

import com.example.demo.service.impl.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/calculator")
public class CalculatorController {
    @Autowired
    private CalculatorService calculatorService;

    @PostMapping("/calculate")
    public String calculate(@RequestParam("calculate") String calculate, @RequestParam("number1") double num1,
                            @RequestParam(value = "number2") double num2, Model model) {
        model.addAttribute("calculate", calculatorService.calculate(calculate, num1, num2));
        return "/calculator";
    }
    @GetMapping()
    public String goToCalculator() {
        return "/calculator";
    }
}
