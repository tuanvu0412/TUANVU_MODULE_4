package com.example.bai_tap.service;


import com.example.bai_tap.model.BlogType;
import com.example.bai_tap.repo.IBlogTypeRepo;
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
    public BlogType findById(int id) {
        for (int i = 0; i < getList().size(); i++) {
            if(getList().get(i).getIdType()==id){
                return getList().get(i);
            }
        }
        return null;
    }

    @Override
        public void update(BlogType blogType) {
        blogTypeRepo.save(blogType);
        }

    @Override
    public void remove(int id) {
        blogTypeRepo.getBlogByIdAndFlagDeleteIsFalse(id);
    }
}
