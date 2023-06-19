package com.example.bai_1.controller;

import com.example.bai_1.model.BoxEmail;
import com.example.bai_1.service.BoxEmailService;
import com.example.bai_1.service.IBoxEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller

@RequestMapping()
public class EmailController {
    @Autowired
    private IBoxEmailService boxEmailService;
    @GetMapping()
    public String showFormDetail(@ModelAttribute("email")BoxEmail boxEmail,Model model){
        BoxEmail email = boxEmailService.getEmail();
        model.addAttribute("email",email);
        return "detail";
    }
    @GetMapping("/setting")
    public String getShowForm(@ModelAttribute("email") BoxEmail email, Model model){
        model.addAttribute("email", new BoxEmail());
        model.addAttribute("languages",boxEmailService.getLanguages());
        model.addAttribute("size",boxEmailService.getSize());

        return "update";
    }
    @PostMapping("/detail")
    public String updateEmail(@ModelAttribute("email") BoxEmail email, Model model){
        model.addAttribute("email",email);
        return "detail";
    }}
