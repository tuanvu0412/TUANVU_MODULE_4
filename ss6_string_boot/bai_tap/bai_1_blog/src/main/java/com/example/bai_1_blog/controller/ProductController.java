package com.example.bai_1_blog.controller;
import com.example.bai_1_blog.model.Blog;
import com.example.bai_1_blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.time.LocalDate;

@Controller
@RequestMapping("/blog")
public class ProductController {
    @Autowired
    private IBlogService blogService;
    @GetMapping
    public String getBlogList(@PageableDefault(size=1)Pageable pageable,Model model){
        model.addAttribute("blogs",this.blogService.findAllByFlagDeleteIsFalse(pageable));
        return "/list";
    }

    @GetMapping("/form-add")
    public String getFormAdd(Model model) {
        model.addAttribute("blog", new Blog());
        return "/form-add";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        blog.setTimes(LocalDate.now());
        blogService.addNewBlog(blog);
        redirectAttributes.addFlashAttribute("msg", "thêm mới thành công");
        return "redirect:/blog";
    }

    @GetMapping("/{id}/detail")
    public String detail(@PathVariable int id, Model model) {
        if (blogService.findById(id) == null) {
            model.addAttribute("massage", "sản phẩm không tồn tại");
            return "redirect:/blog";
        } else {
            model.addAttribute("blog", blogService.findById(id));
        }
        return "/detail";
    }

    @GetMapping("/{id}/delete")
    public String remove(@PathVariable(name = "id") int id, RedirectAttributes redirectAttributes) {
        if (blogService.findById(id) == null) {
            redirectAttributes.addFlashAttribute("msg", "xóa không thành công");
            return "redirect:/blog";
        }
        blogService.remove(id);
        redirectAttributes.addFlashAttribute("msg", "xóa thành công");
        return "redirect:/blog";
    }

    @GetMapping("/{id}/edit")
    public String showFormEdit(@PathVariable(name = "id") int id, Model model, RedirectAttributes redirectAttributes) {
        if (blogService.findById(id) == null) {
            redirectAttributes.addFlashAttribute("msg", "không tìm thấy id");
            return "redirect:/blog";
        } else {
            model.addAttribute("product", blogService.findById(id));
            return "/edit";
        }
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        if (blogService.findById(blog.getId()) == null) {
            redirectAttributes.addFlashAttribute("msg", "sửa không thành công");
            return "redirect:/blog";
        } else {
            blogService.update(blog);
            redirectAttributes.addFlashAttribute("msg", "sửa thành công");
        }
        return "redirect:/blog";
    }

    @GetMapping("/search")
    public String search(@RequestParam(name="name") String name,Pageable pageable, Model model) {
        Page<Blog> blogs = blogService.findOne(name,pageable);
        model.addAttribute("blogs", blogs);
        return "/list";
    }
}
