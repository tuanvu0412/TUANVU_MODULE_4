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
                return  getListBorrow().get(i);
            }
        }
        return null;
    }

    @Override
    public Borrow findByBorrowCode(String borrowCode) {
        for (int i = 0; i < getListBorrow().size(); i++) {
            if(getListBorrow().get(i).getBorrowCode().equals(borrowCode)){
                return getListBorrow().get(i);
            }
        }
        return null;
    }

}
