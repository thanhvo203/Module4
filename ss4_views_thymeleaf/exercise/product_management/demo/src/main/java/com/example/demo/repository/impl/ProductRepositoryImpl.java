package com.example.demo.repository.impl;

import com.example.demo.model.Product;
import com.example.demo.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.PrimitiveIterator;

@Repository
public class ProductRepositoryImpl implements IProductRepository {
    private static List<Product> list = new ArrayList<>();
    static {
        list.add(new Product(1,"MT-15",6000,"Strong","Yamaha"));
        list.add(new Product(2,"MT-09",9000,"PKL","Yamaha"));
        list.add(new Product(3,"MT-03",15000,"300cc","Yamaha"));
        list.add(new Product(4,"Stallions Cafe Mega",10000,"Traditional","Stallions"));
    }
    @Override
    public List<Product> getListProduct() {
        return list;
    }

    @Override
    public void createProduct(Product product) {
        list.add(product);
    }

    @Override
    public void deleteProduct(int id) {
        list.remove(findById(id));
    }


    @Override
    public void editProduct(int id, Product product) {
        if (findById(id) >= 0){
            list.add(id,product);
        }
    }
    @Override
    public int findById(int id) {
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getId() == id){
                return i;
            }
        }
        return -1;
    }

    @Override
    public Product getProductByID(int id) {
        if (findById(id) >= 0) {
            Product product = list.get(findById(id));
            return product;
        }
        return null;
    }

    @Override
    public Product searchProduct(String name) {
        Product product = new Product();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().equals(name)){
                product = list.get(getProductByID(i).getId());
            }
        }
        return product;
    }
}
