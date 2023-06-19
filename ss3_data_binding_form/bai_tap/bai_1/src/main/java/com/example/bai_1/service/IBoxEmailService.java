package com.example.bai_1.service;

import com.example.bai_1.model.BoxEmail;
import org.springframework.ui.Model;

import java.util.List;

public interface IBoxEmailService{
    List<String> getLanguages();
    List<Integer> getSize();

    BoxEmail getEmail();
}
