package com.example.bai_1.service;

import com.example.bai_1.model.Book;
import com.example.bai_1.repo.IBookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService {
    @Autowired
    private IBookRepo bookRepo;

    @Override
    public List<Book> getListBook() {
        return bookRepo.findAll();
    }

    @Override
    public void add(Book book) {
        bookRepo.save(book);
    }

    @Override
    public void delete(Book book) {
        bookRepo.delete(book);
    }

    @Override
    public Book findById(int id) {
        for (int i = 0; i < getListBook().size(); i++) {
            if(getListBook().get(i).getId()==id){
                return getListBook().get(i);
            }
        }
        return null;
    }

    @Override
    public Book findByName(String name) {
        for (int i = 0; i < getListBook().size(); i++) {
            if(getListBook().get(i).getTitle().equals(name)){
                return getListBook().get(i);
            }
        }
        return null;
    }

    @Override
    public void delete(int id) {
        bookRepo.getBookByIdAndFlagDeleteIsFalse(id);
    }
}
