package com.example.bai_tap.controller;


import com.example.bai_tap.model.Blog;
import com.example.bai_tap.model.BlogType;
import com.example.bai_tap.service.IBlogTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/blogTypes")
public class BlogTypeController {
    @Autowired
    private IBlogTypeService blogTypeService;

    @GetMapping()
    public ResponseEntity<BlogType> getListBlogs() {
        this.blogTypeService.getList();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getBlogsDetail(@PathVariable Integer id) {
        if (blogTypeService.findById(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            this.blogTypeService.findById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void createBlog(@Valid @RequestBody BlogType blogType) {
        this.blogTypeService.addNewBlog(blogType);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateBlogs(@RequestBody BlogType blogType, @PathVariable Integer id) {
        if (blogTypeService.findById(id) != null) {
            blogTypeService.update(blogType);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        if (blogTypeService.findById(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            this.blogTypeService.remove(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}
