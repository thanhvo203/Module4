package com.example.demo.service;

import com.example.demo.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface IProductService {
    List<Product> getListProduct();
    void createProduct(Product product);
    void deleteProduct(int id);


    void editProduct(int id, Product product);
    int findById(int id);
    Product getProductByID( int id);

    Product searchProduct(String name);
}
