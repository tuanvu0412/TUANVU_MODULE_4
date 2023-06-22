package com.example.bai_1_blog.service;


import com.example.bai_1_blog.model.Blog;
import com.example.bai_1_blog.repo.IBlogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepo blogRepo;

    @Override
    public List<Blog> getList() {
        return blogRepo.findAll();
    }

    @Override
    public void addNewBlog(Blog blog) {
        blogRepo.save(blog);
    }

    @Override
    public Blog findById(int id) {
        return this.blogRepo.findById(id).orElseThrow(()->new IllegalArgumentException("not found Blog by id"+id));
    }

    @Override
    public void update(Blog blog) {
        blogRepo.updateBlogsByIdIs(blog);
    }

    @Override
    public void remove(int id) {
            this.blogRepo.deleteById(id);
    }

    @Override
    public List<Blog> findOne(String name) {
        return this.blogRepo.searchByName(name);
    }
}
