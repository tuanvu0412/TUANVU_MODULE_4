package com.example.bai_1_blog.service;

import com.example.bai_1_blog.model.Blog;
import com.example.bai_1_blog.model.BlogType;
import com.example.bai_1_blog.repo.IBlogRepo;
import com.example.bai_1_blog.repo.IBlogTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BlogTypeService implements IBlogTypeService{
    @Autowired
    private IBlogTypeRepo blogTypeRepo;
    @Override
    public List<BlogType> getList() {
        return blogTypeRepo.findAll();
    }

    @Override
    public void addNewBlog(BlogType blogType) {
        blogTypeRepo.save(blogType);
    }

    @Override
    public Blog findById(int id) {
        return null;
    }

    @Override
        public void update(BlogType blogType) {
        blogTypeRepo.save(blogType);
        }

    @Override
    public void remove(int id) {
        blogTypeRepo.deleteById(id);
    }
}
