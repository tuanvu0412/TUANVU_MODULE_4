package com.example.bai_1.service;

import com.example.bai_1.model.Book;

import java.util.List;

public interface IBookService {
    List<Book>getListBook();
    void add(Book book);
    void delete(Book book);
    Book findById(int id);
    Book findByName(String name);
    void delete(int id);
}
