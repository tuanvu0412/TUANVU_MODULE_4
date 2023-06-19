package com.example.bai_2.service;

import com.example.bai_2.model.Translation;
import com.example.bai_2.repository.ITranslationRepo;
import com.example.bai_2.repository.TranslationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class TranslationService implements ITranslationService {
    @Autowired
    private ITranslationRepo translationRepo;

    @Override
    public List<Translation> findByKey(String keyword, Model model) {
        List<Translation> translations = this.translationRepo.findByKey();
        for (int i = 0; i < translations.size(); i++) {
            if (translations.get(i).getEn().equalsIgnoreCase(keyword)) {
                model.addAttribute("word", translations.get(i).getVi());
                model.addAttribute("key", keyword);
                return translationRepo.findByKey();
            } else {
                System.out.println("từ bạn tìm không có");
            }
        }
        return translationRepo.findByKey();
    }
}
