package com.example.bai_2.repository;

import com.example.bai_2.model.Translation;

import java.util.Collection;
import java.util.List;

public interface ITranslationRepo {
    List<Translation> findByKey();
}
