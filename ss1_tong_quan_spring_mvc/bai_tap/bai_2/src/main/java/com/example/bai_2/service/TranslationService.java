package com.example.bai_2.service;

import com.example.bai_2.model.Translation;
import com.example.bai_2.repository.ITranslationRepo;
import com.example.bai_2.repository.TranslationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TranslationService implements ITranslationService {
    @Autowired
    private ITranslationRepo translationRepo;

    @Override
    public List<Translation> findAll() {
        return translationRepo.findAll();
    }
}
