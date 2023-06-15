package com.example.bai_1.controller;

import com.example.bai_1.service.IConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConverterController {
    @Autowired
    private IConverterService converterService;

    @GetMapping()
    public String index() {
        return "index";
    }

    @PostMapping("/usd")
    public String submit(@RequestParam("money") float money, Model model) {
        double result = converterService.changeMoney(money);
        model.addAttribute("result1", result);
        return "submit";
    }
}
