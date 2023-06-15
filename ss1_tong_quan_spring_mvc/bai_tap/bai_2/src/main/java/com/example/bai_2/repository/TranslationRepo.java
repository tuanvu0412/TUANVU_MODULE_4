package com.example.bai_2.repository;

import com.example.bai_2.model.Translation;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class TranslationRepo implements ITranslationRepo {
    private static Map<Integer, Translation> translationMap = new HashMap<>();

    static {
        translationMap.put(1, new Translation("hello", "xin chào"));
        translationMap.put(2, new Translation("dog", "con chó"));
        translationMap.put(3, new Translation("cat", "con mèo"));
        translationMap.put(4, new Translation("ahihi", "đồ chó"));
        translationMap.put(5, new Translation("goodbye", "tạm biệt"));
        translationMap.put(6, new Translation("rat", "con chuột"));
        translationMap.put(7, new Translation("lion", "Sư tử"));
    }

    @Override
    public List<Translation> findAll() {
        return new ArrayList<>(translationMap.values());
    }
}
