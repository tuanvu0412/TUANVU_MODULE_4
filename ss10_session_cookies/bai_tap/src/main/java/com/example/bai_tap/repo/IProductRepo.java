package com.example.bai_tap.repo;

import com.example.bai_tap.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepo extends JpaRepository<Product,Long> {
}
