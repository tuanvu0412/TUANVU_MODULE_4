package com.example.bai_tap.service;

import com.example.bai_tap.model.Product;
import com.example.bai_tap.repo.IProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProductService implements IProductService{

    @Autowired
    private IProductRepo productRepository;

    @Override
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public void add(Product product) {
        productRepository.save(product);
    }

    @Override
    public Product findByProduct(Long id) {
        for (int i = 0; i < getListProduct().size(); i++) {
            if(getListProduct().get(i).getId()==id){
                return getListProduct().get(i);
            }
        }
        return null;
    }

    @Override
    public List<Product> getListProduct() {
        return productRepository.findAll();
    }

}
