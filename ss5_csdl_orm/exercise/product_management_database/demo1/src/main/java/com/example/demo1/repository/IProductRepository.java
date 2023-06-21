package com.example.demo1.repository;

import com.example.demo1.model.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepository {
    List<Product> getListProduct();
    void createProduct(Product product);
    void deleteProduct(int id);

    void editProduct(int id,Product product);

    Product getProductByID( int id);
    List<Product> searchProduct(String name);
    boolean checkID(int id);
}
