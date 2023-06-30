package com.example.bai_tap.controller;

import com.example.bai_tap.dto.BlogDto;
import com.example.bai_tap.model.Blog;
import com.example.bai_tap.service.IBlogService;
import com.example.bai_tap.service.IBlogTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/blogs")
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private IBlogTypeService blogTypeService;

    @GetMapping()
    public List<Blog> getListBlogs() {
        return this.blogService.getList();
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getBlogsDetail(@PathVariable Integer id) {
        if (blogService.findById(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            this.blogService.findById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> createBlog(@Valid @RequestBody Blog blog) {
            this.blogService.addNewBlog(blog);
            return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateBlogs(@RequestBody Blog blog, @PathVariable Integer id) {
        if (blogService.findById(id) != null) {
            blogService.update(blog);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        if (blogService.findById(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            this.blogService.remove(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}
