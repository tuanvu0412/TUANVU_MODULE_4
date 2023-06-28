package com.example.bai_1.repo;

import com.example.bai_1.model.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBorrowRepo extends JpaRepository<Borrow,Integer> {
    Borrow findByBorrowCode(String borrowCode);

}
