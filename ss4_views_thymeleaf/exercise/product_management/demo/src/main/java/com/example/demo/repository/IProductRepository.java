package com.example.demo.repository;

import com.example.demo.model.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepository {
    List<Product> getListProduct();
    void createProduct(Product product);
    void deleteProduct(int id);

    void editProduct(int id, Product product);
    int findById(int id);

    Product getProductByID( int id);
    Product searchProduct(String name);
}
