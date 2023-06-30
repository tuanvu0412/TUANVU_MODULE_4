package com.example.bai_tap.service;


import com.example.bai_tap.model.BlogType;

import java.util.List;

public interface IBlogTypeService {
    List<BlogType> getList();

    void addNewBlog(BlogType blogType);

    BlogType findById(int id);

    void update(BlogType blogType);

    void remove(int id);
}
