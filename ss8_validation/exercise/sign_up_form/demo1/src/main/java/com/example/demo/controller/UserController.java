package com.example.demo.controller;

import com.example.demo.dto.SignUpFormDto;
import com.example.demo.model.User;
import jdk.internal.icu.text.NormalizerBase;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/sign-up-form")
public class UserController {

    @GetMapping()
    public String showListSingUp(Model model) {
        model.addAttribute("signUpFormDto", new SignUpFormDto());
        return "/index";
    }

    @PostMapping("/create")
    public String signUp(@Valid @ModelAttribute SignUpFormDto signUpFormDto,BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()){
            return "/index";
        }
        User userEntity = new User();
        BeanUtils.copyProperties(signUpFormDto, userEntity);
        model.addAttribute("message", "Sign up Success");
        return "/result";
    }
}
