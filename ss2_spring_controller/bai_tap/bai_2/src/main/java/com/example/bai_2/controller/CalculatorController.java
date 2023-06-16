package com.example.bai_2.controller;

import com.example.bai_2.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping
public class CalculatorController {
    @Autowired
    private ICalculatorService calculatorService;

    @GetMapping()
    public String calculator() {
        return "index";
    }

    @PostMapping("/calculator")
    public String doSomeThing(@RequestParam double number1, double number2, String calculator, Model model) {
        this.calculatorService.calculator(number1, number2, calculator, model);
        return "index";
    }
}
