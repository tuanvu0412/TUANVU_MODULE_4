package com.example.ss4_thymeleaf.Controller;

import com.example.ss4_thymeleaf.model.Product;
import com.example.ss4_thymeleaf.service.IProductService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/product")
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
    public String add(Product product, RedirectAttributes redirectAttributes){
        productService.addNewProduct(product);
        redirectAttributes.addFlashAttribute("msg","thêm mới thành công");
        return "redirect:/product";
    }
    @GetMapping("/{id}/detail")
    public String detail(@PathVariable int id, Model model){
        model.addAttribute("product", productService.findById(id));
        return "/detail";
    }
    @GetMapping("/{id}/delete")
    public String remove(@PathVariable("id") int id, Model model){
        model.addAttribute("remove", productService.remove(id));
        model.addAttribute("msg1","xóa thành công");
        return "redirect:/product";
    }
    @GetMapping("/{id}/edit")
    public String showFormEdit(@PathVariable("id") int id, Model model){
        model.addAttribute("product", productService.findById(id));
        return "/edit";
    }
    @PostMapping("/edit")
    public String edit(Product product, Model model){
        productService.update(product);
        model.addAttribute("msg2","sửa thành công");
        return "redirect:/product";
    }
}
