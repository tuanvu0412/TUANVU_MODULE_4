package com.example.ss4_thymeleaf.controller;

import com.example.ss4_thymeleaf.model.Product;
import com.example.ss4_thymeleaf.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("")
public class ProductController {
    @Autowired
    private IProductService productService;
    @GetMapping()
    public String getListProduct(Model model){
        model.addAttribute("product",productService.getList());
        return "/list";
    }
    @GetMapping("/form-add")
    public  String getFormAdd(Model model){
        model.addAttribute("product",new Product());
        return "/form-add";
    }
    @PostMapping("/add")
    public String add(@ModelAttribute Product product, RedirectAttributes redirectAttributes){
        productService.addNewProduct(product);
        redirectAttributes.addFlashAttribute("msg","thêm mới thành công");
        return "redirect:/";
    }
    @GetMapping("/{id}/detail")
    public String detail(@PathVariable int id, Model model){
        if(productService.findById(id) == null){
            model.addAttribute("massage","sản phẩm không tồn tại");
            return "redirect:/product";
        }else {
            model.addAttribute("product", productService.findById(id));
        }
        return "/detail";
    }
    @GetMapping("/{id}/delete")
    public String remove(@PathVariable(name = "id") int id, RedirectAttributes redirectAttributes){
        if(productService.findById(id)==null){
            redirectAttributes.addFlashAttribute("msg","xóa không thành công");
            return "redirect:/";
        }
        productService.remove(id);
        redirectAttributes.addFlashAttribute("msg","xóa thành công");
        return "redirect:/";
    }
    @GetMapping("/{id}/edit")
    public String showFormEdit(@PathVariable(name="id") int id, Model model){
        model.addAttribute("product", productService.findById(id));
        return "/edit";
    }
    @PostMapping("/edit")
    public String edit(@ModelAttribute Product product, RedirectAttributes redirectAttributes){
        if(productService.findById(product.getId())==null){
            redirectAttributes.addFlashAttribute("msg","sửa không thành công");
            return "redirect:/";
        }else {
            productService.update(product);
            redirectAttributes.addFlashAttribute("msg", "sửa thành công");
        }
        return "redirect:/";
    }
    @GetMapping("/search")
    public String search(@RequestParam("search") String name, Model model){
        productService.findOne(name);
        model.addAttribute("search",name);
        return "redirect:/";
    }
}
