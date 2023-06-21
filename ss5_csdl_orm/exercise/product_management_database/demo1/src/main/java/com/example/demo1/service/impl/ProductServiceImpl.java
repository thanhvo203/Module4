package com.example.demo1.service.impl;

import com.example.demo1.model.Product;
import com.example.demo1.repository.impl.ProductRepositoryImpl;
import com.example.demo1.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {
     @Autowired
     private ProductRepositoryImpl productRepository;
         @Override
    public List<Product> getListProduct() {
        return productRepository.getListProduct();
    }

    @Override
    public void createProduct(Product product) {
       productRepository.createProduct(product);
    }

    @Override
    public void deleteProduct(int id) {
      productRepository.deleteProduct(id);
    }

    @Override
    public void editProduct(int id, Product product) {
       productRepository.editProduct(id,product);
    }


    @Override
    public Product getProductByID(int id) {
        return productRepository.getProductByID(id);
    }

    @Override
    public List<Product> searchProduct(String name) {
        return productRepository.searchProduct(name);
    }

    @Override
    public boolean checkID(int id) {
        return productRepository.checkID(id);
    }
}
