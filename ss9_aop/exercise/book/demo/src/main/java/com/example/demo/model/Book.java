package com.example.demo.model;

import javax.persistence.*;
import java.util.List;
@Entity
public class Book {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private int id;

    private String nameBook;

    private int countBook;
    private boolean checkStatus;

    public Book() {
    }

    public Book(int id, String nameBook, int countBook, boolean checkStatus) {
        this.id = id;
        this.nameBook = nameBook;
        this.countBook = countBook;
        this.checkStatus = checkStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public int getCountBook() {
        return countBook;
    }

    public void setCountBook(int countBook) {
        this.countBook = countBook;
    }

    public boolean isCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(boolean checkStatus) {
        this.checkStatus = checkStatus;
    }
}
