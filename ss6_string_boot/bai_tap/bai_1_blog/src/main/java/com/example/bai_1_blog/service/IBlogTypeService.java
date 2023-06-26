package com.example.bai_1_blog.service;

import com.example.bai_1_blog.model.Blog;
import com.example.bai_1_blog.model.BlogType;

import java.util.List;

public interface IBlogTypeService {
    List<BlogType> getList();

    void addNewBlog(BlogType blogType);

    Blog findById(int id);

    void update(BlogType blogType);

    void remove(int id);
}
