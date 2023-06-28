package com.example.bai_1.controller;

import com.example.bai_1.model.Borrow;
import com.example.bai_1.service.IBookService;
import com.example.bai_1.service.IBorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/Borrows")
public class BorrowController {
    @Autowired
    private IBorrowService borrowService;
    @Autowired
    private IBookService bookService;
    @GetMapping
    public String getListBorrow(Model model){
        model.addAttribute("borrows",this.borrowService.getListBorrow());
        return "/list-borrow";
    }
    @GetMapping("/form-add-borrows")
    public String showFormAdd(Model model){
        model.addAttribute("borrows",new Borrow());
        model.addAttribute("books", this.bookService.getListBook());
        return "/form-add-borrows";
    }
    @PostMapping("/add")
    public String add(@ModelAttribute(name="borrows") Borrow borrow, RedirectAttributes redirectAttributes){
        this.borrowService.add(borrow);
        redirectAttributes.addFlashAttribute("msg","thêm mới thành công");
        return "redirect:/Borrows";
    }
    @PostMapping("/return")
    public void returnBook(@RequestParam("borrowCode")String borrowCode){
        borrowService.checkBorrowCode(borrowCode);
    }
}
