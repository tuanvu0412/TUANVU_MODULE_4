package com.example.bai_1.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name="borrows")
public class Borrow {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String borrowName;
    private String borrowDate;
    private String returnDate;
    private String borrowCode;
    @ManyToOne
    @JoinColumn(name="bookId",nullable = false)
    private Book book;
    private  boolean flagDelete=false;

    public Borrow() {
    }

    public Borrow(int id, String borrowName, String borrowDate, String returnDate, String borrowCode, Book book, boolean flagDelete) {
        this.id = id;
        this.borrowName = borrowName;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.borrowCode = borrowCode;
        this.book = book;
        this.flagDelete = flagDelete;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBorrowName() {
        return borrowName;
    }

    public void setBorrowName(String borrowName) {
        this.borrowName = borrowName;
    }

    public String getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(String borrowDate) {
        this.borrowDate = borrowDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public String getBorrowCode() {
        return borrowCode;
    }

    public void setBorrowCode(String borrowCode) {
        this.borrowCode = borrowCode;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public boolean isFlagDelete() {
        return flagDelete;
    }

    public void setFlagDelete(boolean flagDelete) {
        this.flagDelete = flagDelete;
    }
}
