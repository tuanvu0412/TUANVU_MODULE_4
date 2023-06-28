package com.example.bai_1.repo;

import com.example.bai_1.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepo extends JpaRepository<Book,Integer> {
        Book  getBookByIdAndFlagDeleteIsFalse(int id);
        Book findBookByTitle(String title);
}
