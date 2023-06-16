package com.example.bai_2.service.impl;

import com.example.bai_2.service.ICalculatorService;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class CalculatorService implements ICalculatorService {
    @Override
    public void calculator(double number1, double number2, String calculator, Model model) {
        double result = 0;
        switch (calculator) {
            case "addition":
                result = number1 + number2;
                calculator = "addition";
                model.addAttribute("number1", number1);
                model.addAttribute("number2", number2);
                model.addAttribute("result", result);
                break;
            case "subtraction":
                result = number1 - number2;
                calculator = "subtraction";
                model.addAttribute("number1", number1);
                model.addAttribute("number2", number2);
                model.addAttribute("result", result);
                break;
            case "multiplication":
                result = number1 * number2;
                calculator = "multiplication";
                model.addAttribute("number1", number1);
                model.addAttribute("number2", number2);
                model.addAttribute("result", result);
                break;
            case "division":
                if (number2 == 0) {
                    model.addAttribute("message", "không thể chia hết cho 0");
                } else {
                    result = number1 / number2;
                    calculator = "division";
                    model.addAttribute("number1", number1);
                    model.addAttribute("number2", number2);
                    model.addAttribute("result", result);
                    break;
                }
        }
        model.addAttribute("calculator", calculator);
    }
}
