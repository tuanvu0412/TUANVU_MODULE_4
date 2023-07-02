package com.example.bai_1_blog.repo;

import com.example.bai_1_blog.model.Blog;
import com.example.bai_1_blog.model.BlogType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBlogTypeRepo extends JpaRepository<BlogType,Integer> {
    Blog getBlogByIdAndFlagDeleteIsFalse(int id);
}
