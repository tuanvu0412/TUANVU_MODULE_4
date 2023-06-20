package com.example.ss4_thymeleaf.service;

import com.example.ss4_thymeleaf.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> getList();
    void addNewProduct(Product product);
    Product findById(int id);
    void update( Product product);

    Object remove(int id);
}
