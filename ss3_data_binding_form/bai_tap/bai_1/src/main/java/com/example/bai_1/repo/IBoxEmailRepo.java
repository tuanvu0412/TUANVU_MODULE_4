package com.example.bai_1.repo;

import com.example.bai_1.model.BoxEmail;

import java.util.List;

public interface IBoxEmailRepo {
    List<String> getLanguages();
    List<Integer>getSize();
    BoxEmail getEmail();
}
