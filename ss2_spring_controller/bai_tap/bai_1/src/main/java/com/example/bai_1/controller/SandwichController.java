package com.example.bai_1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;

@Controller
@RequestMapping
public class SandwichController {
    @GetMapping()
    public String choice(){
        return "index";
    }
    @PostMapping("/choice")
    public String save(@RequestParam("name") String [] name, Model model){
        model.addAttribute("result", Arrays.toString(name));
        return "index";
    }
}
