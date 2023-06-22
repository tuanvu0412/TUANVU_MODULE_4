package com.example.bai_1_blog.service;

import com.example.bai_1_blog.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> getList();

    void addNewBlog(Blog blog);

    Blog findById(int id);

    void update(Blog blog);

    void remove(int id);

    List<Blog> findOne(String name);
}
