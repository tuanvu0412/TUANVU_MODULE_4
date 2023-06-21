package com.example.ss4_thymeleaf.repo;

import com.example.ss4_thymeleaf.model.Product;

import java.util.List;

public interface IProductRepo {
    List<Product> getList();
    void addNewProduct(Product product);

    Product findById(int id);
    void update( Product product);

    void remove(int id);
    List<Product> findOne(String name);
}
