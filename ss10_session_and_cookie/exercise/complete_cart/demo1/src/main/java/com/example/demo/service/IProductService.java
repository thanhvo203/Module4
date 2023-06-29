package com.example.demo.service;

import com.example.demo.model.Product;
import org.apache.catalina.LifecycleState;

import java.util.List;

public interface IProductService {
    List<Product> showListProduct();
    Product findProductByID(int id);
}
