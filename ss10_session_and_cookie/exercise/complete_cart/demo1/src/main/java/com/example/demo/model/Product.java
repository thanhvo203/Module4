package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table (name = "product_cart")
public class Product {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int id;
    private String nameProduct;

    private double priceProduct;

    private String description;

    private boolean checkStatus;

    public Product(int id, String nameProduct, double priceProduct, String description,boolean checkStatus) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.priceProduct = priceProduct;
        this.description = description;
        this.checkStatus = checkStatus;
    }

    public Product(String nameProduct, double priceProduct, String description, boolean checkStatus) {
        this.nameProduct = nameProduct;
        this.priceProduct = priceProduct;
        this.description = description;
        this.checkStatus = checkStatus;

    }

    public boolean isCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(boolean checkStatus) {
        this.checkStatus = checkStatus;
    }

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public double getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(double priceProduct) {
        this.priceProduct = priceProduct;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
