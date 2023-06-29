package com.example.demo.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Product,Integer> productIntegerMap = new HashMap<>();

    public Cart() {
    }

    public Cart(Map<Product, Integer> productIntegerMap) {
        this.productIntegerMap = productIntegerMap;
    }

    public Map<Product,Integer> getProducts() {
        return productIntegerMap;
    }

    private boolean checkItemInCart(Product product){
        for (Map.Entry<Product, Integer> entry : productIntegerMap.entrySet()) {
            if(entry.getKey().getId() == (product.getId())){
                return true;
            }
        }
        return false;
    }

    private Map.Entry<Product, Integer> selectItemInCart(Product product){
        for (Map.Entry<Product, Integer> entry : productIntegerMap.entrySet()) {
            if(entry.getKey().getId() == (product.getId())){
                return entry;
            }
        }
        return null;
    }

    public void addProduct(Product product){
        if (!checkItemInCart(product)){
            productIntegerMap.put(product,1);
        } else {
            Map.Entry<Product, Integer> itemEntry = selectItemInCart(product);
            Integer newQuantity = itemEntry.getValue() + 1;
            productIntegerMap.replace(itemEntry.getKey(),newQuantity);
        }
    }
    public void subtractProduct(Product product){
        Map.Entry<Product, Integer> itemEntry = selectItemInCart(product);
        if (itemEntry.getValue() == 0){
            productIntegerMap.remove(itemEntry.getKey());
        }else {
            Integer newQuantity = itemEntry.getValue() - 1;
            productIntegerMap.replace(itemEntry.getKey(),newQuantity);
        }
    }

    public Integer countProductQuantity(){
        Integer productQuantity = 0;
        for (Map.Entry<Product, Integer> entry : productIntegerMap.entrySet()) {
            productQuantity += entry.getValue();
        }
        return productQuantity;
    }

    public Integer countItemQuantity(){
        return productIntegerMap.size();
    }

    public Float countTotalPayment(){
        float payment = 0;
        for (Map.Entry<Product, Integer> entry : productIntegerMap.entrySet()) {
            payment += entry.getKey().getPriceProduct() * (float) entry.getValue();
        }
        return payment;
    }


    public void deleteCart(Product product){
        Map.Entry<Product, Integer> entry = selectItemInCart(product);
        productIntegerMap.remove(entry.getKey());
    }
}
