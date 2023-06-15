package com.example.bai_2.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public interface IDictionaryService {
   String translate(String word);
}
