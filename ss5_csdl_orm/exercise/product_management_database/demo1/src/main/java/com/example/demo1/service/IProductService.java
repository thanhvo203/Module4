package com.example.demo1.service;

import com.example.demo1.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface IProductService {
    List<Product> getListProduct();
    void createProduct(Product product);
    void deleteProduct(int id);


    void editProduct(int id,Product product);
    Product getProductByID( int id);

    List<Product> searchProduct(String name);
    boolean checkID(int id);
}
