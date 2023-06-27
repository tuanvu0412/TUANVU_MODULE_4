package com.example.bai_1.controller;

import com.example.bai_1.dto.UserDto;

import com.example.bai_1.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    @GetMapping()
    public String getFormUser(Model model){
      model.addAttribute("user",new UserDto());
        return "/index";
    }
    @PostMapping("/validateUser")
    public String checkValidation(@Validated @ModelAttribute("user") UserDto userDto, BindingResult bindingResult){
        new UserDto().validate(userDto,bindingResult);
        if(bindingResult.hasErrors()){
            return "/index";
        }
        User user= new User();
        BeanUtils.copyProperties(userDto,user);
        return "/result";
    }
}
