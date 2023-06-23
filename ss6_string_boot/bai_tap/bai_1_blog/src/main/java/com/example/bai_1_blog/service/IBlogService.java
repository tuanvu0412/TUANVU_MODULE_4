package com.example.bai_1_blog.service;

import com.example.bai_1_blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    List<Blog> getList();

    void addNewBlog(Blog blog);

    Blog findById(int id);

    void update(Blog blog);

    void remove(int id);

    Page<Blog> findOne(String name,Pageable pageable);
    Page<Blog> getBlogWithPageable(Pageable pageable);
}
