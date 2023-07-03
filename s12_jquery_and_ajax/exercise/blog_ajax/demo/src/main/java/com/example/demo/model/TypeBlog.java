package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table (name = "type_blog")
public class TypeBlog {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String nameTypeBlog;

    private boolean checkStatus;

    public TypeBlog(int id, String typeBlog, boolean checkStatus) {
        this.id = id;
        this.nameTypeBlog = typeBlog;
        this.checkStatus = checkStatus;
    }

    public TypeBlog(String typeBlog, boolean checkStatus) {
        this.nameTypeBlog = typeBlog;
        this.checkStatus = checkStatus;
    }
    public TypeBlog(String typeBlog){
        this.nameTypeBlog = typeBlog;
    }

    public TypeBlog() {
    }

    public boolean isCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(boolean checkStatus) {
        this.checkStatus = checkStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameTypeBlog() {
        return nameTypeBlog;
    }

    public void setNameTypeBlog(String typeBlog) {
        this.nameTypeBlog = typeBlog;
    }

}
