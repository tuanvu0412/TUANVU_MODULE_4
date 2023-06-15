package com.example.bai_2.controller;

import com.example.bai_2.model.Translation;
import com.example.bai_2.repository.ITranslationRepo;
import com.example.bai_2.repository.TranslationRepo;
import com.example.bai_2.service.ITranslationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/translation")
public class TranslationController {
    @Autowired
    private ITranslationService translationService;

    @GetMapping()
    public String search() {
        return "index";
    }

    @PostMapping("/result")
    public String meaning(@RequestParam String keyword, Model model) {
        List<Translation> translations = this.translationService.findAll();
        for (int i = 0; i < translations.size(); i++) {
            if (translations.get(i).getEn().equalsIgnoreCase(keyword)) {
                model.addAttribute("word", translations.get(i).getVi());
                model.addAttribute("key", keyword);
                return "mean";
            } else {
                System.out.println("từ bạn tìm không có");
            }
        }
        return "mean";
    }
}
