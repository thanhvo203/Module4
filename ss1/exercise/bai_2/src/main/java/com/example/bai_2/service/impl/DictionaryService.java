package com.example.bai_2.service.impl;

import com.example.bai_2.repository.impl.DictionaryRepository;
import com.example.bai_2.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DictionaryService implements IDictionaryService {
    @Autowired
    private DictionaryRepository dictionaryRepository;

    @Override
    public String translate(String word) {
        Map<String,String> map = dictionaryRepository.getMapTranslate();
        for (String englishWord: map.keySet()) {
            if(word.equals(englishWord.toLowerCase())){
                word = map.get(englishWord);
            }
        }
        if(word.equals("")){
            word = "Không tìm thấy";
        }
        return word;
    }
}
