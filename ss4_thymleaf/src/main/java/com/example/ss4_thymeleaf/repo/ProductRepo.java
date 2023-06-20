package com.example.ss4_thymeleaf.repo;

import com.example.ss4_thymeleaf.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepo implements IProductRepo {
    private static List<Product> products = new ArrayList<>();

    static {
        products.add(new Product(1, "DellXPS200", 1000));
        products.add(new Product(2, "DellXPS300", 1100));
        products.add(new Product(3, "DellXPS400", 1200));
    }

    @Override
    public List<Product> getList() {
        return products;
    }

    @Override
    public void addNewProduct(Product product) {
        products.add(product);
    }

    @Override
    public Product findById(int id) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                return products.get(i);
            }
        }
        return null;
    }

    @Override
    public void update( Product product) {
        for (int i = 0; i < products.size(); i++) {
            if(products.get(i).getId()==product.getId()){
                products.set(i,product);
            }
        }
    }

    @Override
    public void remove(int id) {
        for (Product p:products){
            if(p.getId()==id){
                products.remove(p);
                break;
            }
        }
    }
}
