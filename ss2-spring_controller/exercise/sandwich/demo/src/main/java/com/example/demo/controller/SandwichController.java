package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/condiments")
public class SandwichController {

    @PostMapping("/save")
    public String save(@RequestParam(value = "condiment",required = false) String[] condiment, Model model) {
        if (condiment == null) {
            model.addAttribute("list","Please choose condiment");
        }else{
            model.addAttribute("list", Arrays.toString(condiment));
        }
        return "/condiments";
    }
    @GetMapping()
    public String goToCondimentS() {
        return "/condiments";
    }
}
