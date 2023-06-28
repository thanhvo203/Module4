package com.example.demo.controller;


import com.example.demo.service.impl.BookServiceImpl;
import com.example.demo.service.impl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/order")
public class OrderController {
   @Autowired
    private OrderServiceImpl orderService;

   @GetMapping()
    public String showListOrder(@PageableDefault(size = 2) Pageable pageable, Model model){
       model.addAttribute("orders",orderService.findOrderByCheckStatusIsFalse(pageable));
       return "/list-order";
   }
}
