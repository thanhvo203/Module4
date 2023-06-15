package com.example.bai_2.controller;

import com.example.bai_2.service.impl.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;
@Controller
@RequestMapping("/dictionary")
public class DictionaryController {
    @Autowired
    private DictionaryService dictionaryService;
    @PostMapping("/translate")
    public String getWord(Model model ,  @RequestParam("english") String english ){
        model.addAttribute("word", dictionaryService.translate(english));
        return "/dictionary";
    }
    @GetMapping()
    public String goToDictionary(){
        return "/dictionary";
    }
}
