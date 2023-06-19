package com.example.demo1.controller;

import com.example.demo1.model.Email;
import com.example.demo1.repository.impl.EmailRepositoryImpl;
import com.example.demo1.service.impl.EmailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller

@RequestMapping("/email")
public class EmailController {
    @Autowired
    private EmailServiceImpl emailService;
    @GetMapping()
    public String showFormDetail(Model model){
        Email email = emailService.getEmail();
        model.addAttribute("email",email);
        return "/detail-email";
    }
    @GetMapping("/setting-email")
    public String getShowForm(@ModelAttribute Email email, Model model){
        model.addAttribute("email", new Email());
        model.addAttribute("languages",emailService.getLanguages());
        model.addAttribute("size",emailService.getSize());
        return "/setting-email";
    }
    @PostMapping("/detail-email")
    public String updateEmail(@ModelAttribute Email email, Model model){
       model.addAttribute("email",email);
        return "/detail-email";
    }

}
