package com.example.bai_tap.repo;


import com.example.bai_tap.model.BlogType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBlogTypeRepo extends JpaRepository<BlogType,Integer> {
    BlogType getBlogByIdAndFlagDeleteIsFalse(int id);
}
