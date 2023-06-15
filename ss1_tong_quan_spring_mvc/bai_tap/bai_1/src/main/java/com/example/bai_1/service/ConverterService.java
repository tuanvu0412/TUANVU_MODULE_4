package com.example.bai_1.service;

import org.springframework.stereotype.Service;

@Service
public class ConverterService implements IConverterService {
    @Override
    public Float changeMoney(float money) {
        return money * 26000;
    }
}
