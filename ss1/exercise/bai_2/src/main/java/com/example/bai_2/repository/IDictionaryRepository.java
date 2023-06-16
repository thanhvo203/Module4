package com.example.bai_2.repository;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public interface IDictionaryRepository {
    Map<String,String> getMapTranslate();
}
