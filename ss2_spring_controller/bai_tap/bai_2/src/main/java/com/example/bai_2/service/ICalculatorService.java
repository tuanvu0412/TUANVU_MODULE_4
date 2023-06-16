package com.example.bai_2.service;

import org.springframework.ui.Model;

public interface ICalculatorService {
    void calculator(double number1, double number2, String calculator, Model model);
}
