package com.example.ss4_thymeleaf.service;

import com.example.ss4_thymeleaf.model.Product;
import com.example.ss4_thymeleaf.repo.IProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService implements IProductService{
    @Autowired
    private IProductRepo productRepo;
    @Override
    public List<Product> getList() {
        return productRepo.getList();
    }

    @Override
    public void addNewProduct(Product product) {
        productRepo.addNewProduct(product);
    }

    @Override
    public Product findById(int id) {
        return productRepo.findById(id);
    }

    @Override
    public void update( Product product) {
        productRepo.update(product);
    }

    @Override
    public Object remove(int id) {
        productRepo.remove(id);
        return null;
    }
}
