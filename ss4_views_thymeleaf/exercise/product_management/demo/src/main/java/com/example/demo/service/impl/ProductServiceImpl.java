package com.example.demo.service.impl;

import com.example.demo.model.Product;
import com.example.demo.repository.impl.ProductRepositoryImpl;
import com.example.demo.service.IProductService;
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
        product.setId(product.getId()+1);
        productRepository.createProduct(product);
    }

    @Override
    public void deleteProduct(int id) {
        productRepository.deleteProduct(id);
    }


    @Override
    public void editProduct(int id, Product product) {
        productRepository.editProduct(id, product);
    }

    @Override
    public int findById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public Product getProductByID(int id) {
        return productRepository.getProductByID(id);
    }

    @Override
    public Product searchProduct(String name) {
        return productRepository.searchProduct(name);
    }
}
