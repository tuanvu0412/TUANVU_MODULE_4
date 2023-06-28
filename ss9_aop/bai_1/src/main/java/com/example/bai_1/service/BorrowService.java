package com.example.bai_1.service;

import com.example.bai_1.model.Book;
import com.example.bai_1.model.Borrow;
import com.example.bai_1.repo.IBookRepo;
import com.example.bai_1.repo.IBorrowRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BorrowService implements IBorrowService{
    @Autowired
    private IBorrowRepo borrowRepo;
    @Autowired
    private IBookRepo bookRepo;

    @Override
    public List<Borrow> getListBorrow() {
        return borrowRepo.findAll();
    }

    @Override
    public void add(Borrow borrow) {
            borrowRepo.save(borrow);
    }

    @Override
    public void delete(Borrow borrow) {
        borrowRepo.delete(borrow);
    }

    @Override
    public Borrow findById(int id) {
        for (int i = 0; i < getListBorrow().size(); i++) {
            if(getListBorrow().get(i).getId()==id){
                return getListBorrow().get(i);
            }
        }
        return null;
    }

    @Override
    public void borrowBook(Borrow borrow){
        Book book=bookRepo.findById(borrow.getId()).orElse(null);
        if(book==null||book.getQuantity()<=0){
            throw  new RuntimeException("sách không còn trong kho");
        }
        book.setQuantity(book.getQuantity()-1);
        bookRepo.save(book);
        borrowRepo.save(borrow);
    }

    @Override
    public void checkBorrowCode(String borrowCode) {
        Borrow borrow=borrowRepo.findByBorrowCode(borrowCode);
        if(borrow==null){
            throw new RuntimeException("mã số trả sách không hợp lệ");
        }
        borrow.setReturnDate(borrowCode);
        borrowRepo.save(borrow);
    }
}
