package com.example.bai_tap.controller;
import com.example.bai_tap.model.Blog;
import com.example.bai_tap.service.IBlogService;
import com.example.bai_tap.service.IBlogTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.naming.directory.SearchResult;
import java.util.List;


@RestController
@RequestMapping("/blogs")
@CrossOrigin("*")
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private IBlogTypeService blogTypeService;

    @GetMapping()
    public ResponseEntity<List<Blog>> getListBlogs() {
         return new ResponseEntity<>(blogService.getList(), HttpStatus.OK);
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
    public void createBlog( @RequestBody Blog blog) {
            this.blogService.addNewBlog(blog);
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

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        if (blogService.findById(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            this.blogService.remove(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @GetMapping("/search/{search}")
    public ResponseEntity<List<Blog>> search(@PathVariable(name="search") String search) {
        List<Blog> blogList = blogService.search(search);
        if(blogList.size()==0){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<>(blogList,HttpStatus.OK);
        }
    }
//    @GetMapping("/load-more/{id}")
//    public ResponseEntity<?> loadMorePosts(@PathVariable(name="id") int id) {
//        if(blogService.findById(id)==null){
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }else {
//           return new ResponseEntity<>(blogService.findById(id),HttpStatus.OK);
//        }
//    }
}
