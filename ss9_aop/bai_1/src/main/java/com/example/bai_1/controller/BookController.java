package com.example.bai_1.controller;

import com.example.bai_1.model.Book;
import com.example.bai_1.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    private IBookService bookService;
    @GetMapping()
    public String getListBook(Model model){
        model.addAttribute("books",this.bookService.getListBook());
        return "/list";
    }
    @GetMapping("/form-add")
    public String showFormAdd(Model model){
        model.addAttribute("add", new Book());
        return "/form-add";
    }
    @PostMapping("/add")
    public String add(@ModelAttribute(name = "add") Book book, RedirectAttributes redirectAttributes){
       this.bookService.add(book);
       redirectAttributes.addFlashAttribute("msg","thêm mới thành công");
       return "redirect:/books";
    }
    @GetMapping("/{id}/delete")
    public String delete(@PathVariable(name = "id")int id,RedirectAttributes redirectAttributes){
        if(bookService.findById(id)==null){
            redirectAttributes.addFlashAttribute("msg","không tìm thấy");
            return "redirect:/books";
        }else {
            bookService.delete(id);
            redirectAttributes.addFlashAttribute("msg","xóa thành công");
            return "redirect:/books";
        }
    }
}
