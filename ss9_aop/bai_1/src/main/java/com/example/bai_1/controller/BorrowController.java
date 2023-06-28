package com.example.bai_1.controller;

import com.example.bai_1.model.Book;
import com.example.bai_1.model.Borrow;
import com.example.bai_1.service.IBookService;
import com.example.bai_1.service.IBorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Random;

@Controller
@RequestMapping("/Borrows")
public class BorrowController {
    @Autowired
    private IBorrowService borrowService;
    @Autowired
    private IBookService bookService;

    @GetMapping
    public String getListBorrow(Model model) {
        model.addAttribute("borrows", this.borrowService.getListBorrow());
        return "/list-borrow";
    }

    @GetMapping("/form-add-borrows")
    public String showFormAdd(Model model) {
        model.addAttribute("borrows", new Borrow());
        model.addAttribute("books", this.bookService.getListBook());
        return "/form-add-borrows";
    }

    @PostMapping("/add")
    public String borrowBook(@ModelAttribute(name="borrows")Borrow borrow, RedirectAttributes redirectAttributes) {

        Book book = bookService.findById(borrow.getBook().getId());
        if (book == null || book.getQuantity() == 0) {
            throw new RuntimeException("sách đã hết");
        } else {
            book.setQuantity(book.getQuantity() - 1);
            bookService.add(book);
            redirectAttributes.addFlashAttribute("msg", "bạn đã thuê thành công");
            redirectAttributes.addFlashAttribute("msg1","mã thuê của bạn là : "+borrow.getBorrowCode());
            return "redirect:/Borrows";
        }
//        public static String generateBorrowCode () {
//            Random random = new Random();
//            int code = random.nextInt(99999);
//            return String.format("%05d", code);
//        }
    }
    @GetMapping("/{id}/return")
    public String returnBook(@RequestParam(name="id")Borrow borrow,RedirectAttributes redirectAttributes){
        Book book=bookService.findById(borrow.getBook().getQuantity());
        if(borrowService.findByBorrowCode(borrow.getBorrowCode())==null){
            redirectAttributes.addFlashAttribute("mã sách bạn muốn trả chưa đúng");
            return "redirect:/Borrows";
        }else {
            book.setQuantity(book.getQuantity()+1);
            borrowService.delete(borrow);
            redirectAttributes.addFlashAttribute("msg","bạn đã trả thành công");
            return "redirect:/Borrows";
        }
    }
}