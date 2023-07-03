package com.example.bai_1_blog.controller;

import com.example.bai_1_blog.model.Blog;
import com.example.bai_1_blog.model.BlogType;
import com.example.bai_1_blog.service.IBlogService;
import com.example.bai_1_blog.service.IBlogTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
@Controller
@RequestMapping("/blogTypes")
public class BlogTypeController {
    @Autowired
    private IBlogTypeService blogTypeService;
    @GetMapping
    public String getBlogList(Model model) {
        model.addAttribute("blogType", this.blogTypeService.getList());
        return "/list-blog-type";
    }

    @GetMapping("/form-add")
    public String getFormAdd(Model model) {
        model.addAttribute("blogType", new BlogType());
        return "/form-add";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute BlogType blog, RedirectAttributes redirectAttributes) {
        blogTypeService.addNewBlog(blog);
        redirectAttributes.addFlashAttribute("msg", "thêm mới thành công");
        return "redirect:/blogTypes";
    }

    @GetMapping("/{id}/delete")
    public String remove(@PathVariable(name = "id") int id, RedirectAttributes redirectAttributes) {
        if (blogTypeService.findById(id) == null) {
            redirectAttributes.addFlashAttribute("msg", "xóa không thành công");
            return "redirect:/blog";
        }
        blogTypeService.remove(id);
        redirectAttributes.addFlashAttribute("msg", "xóa thành công");
        return "redirect:/blogTypes";
    }

    @GetMapping("/{id}/edit")
    public String showFormEdit(@PathVariable(name = "id") int id, Model model, RedirectAttributes redirectAttributes) {
        if (blogTypeService.findById(id) == null) {
            redirectAttributes.addFlashAttribute("msg", "không tìm thấy id");
            return "redirect:/blogTypes";
        } else {
            model.addAttribute("product", blogTypeService.findById(id));
            return "/edit";
        }
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute int id,BlogType blogType, RedirectAttributes redirectAttributes) {
        if (blogTypeService.findById(id) == null) {
            redirectAttributes.addFlashAttribute("msg", "sửa không thành công");
            return "redirect:/blogTypes";
        } else {
            blogTypeService.update(blogType);
            redirectAttributes.addFlashAttribute("msg", "sửa thành công");
        }
        return "redirect:/blogTypes";
    }
}
