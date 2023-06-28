package com.example.bai_1.service;

import com.example.bai_1.model.Book;
import com.example.bai_1.model.Borrow;

import java.util.List;

public interface IBorrowService {
    List<Borrow> getListBorrow();

    void add(Borrow borrow);

    void delete(Borrow borrow);

    Borrow findById(int id);
    void borrowBook(Borrow borrow);
    void checkBorrowCode(String borrowCode);
}
