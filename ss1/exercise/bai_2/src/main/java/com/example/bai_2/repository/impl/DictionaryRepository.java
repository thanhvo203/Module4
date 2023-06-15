package com.example.bai_2.repository.impl;

import com.example.bai_2.repository.IDictionaryRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class DictionaryRepository implements IDictionaryRepository {
    @Override
    public Map<String, String> translate() {
        Map<String,String> map = new HashMap<>();
        map.put("dog","con chó");
        map.put("lion","sư tử");
        map.put("gun","súng");
        map.put("balloon","bong bóng");
        map.put("food","thức ăn");
        map.put("clothes","quần áo");
        return map;
    }
}
