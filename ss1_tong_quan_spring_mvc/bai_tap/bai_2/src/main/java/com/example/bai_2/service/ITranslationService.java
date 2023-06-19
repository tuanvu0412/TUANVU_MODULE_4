package com.example.bai_2.service;

import com.example.bai_2.model.Translation;
import org.springframework.ui.Model;

import java.util.List;

public interface ITranslationService {
    List<Translation> findByKey(String keyword, Model model);
}
