package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table (name = "type_blog")
public class TypeBlog {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int id;
    private String typeBlog;

    private boolean checkStatus;

    public TypeBlog(int id, String typeBlog, boolean checkStatus) {
        this.id = id;
        this.typeBlog = typeBlog;
        this.checkStatus = checkStatus;
    }

    public TypeBlog(String typeBlog, boolean checkStatus) {
        this.typeBlog = typeBlog;
        this.checkStatus = checkStatus;
    }
    public TypeBlog(String typeBlog){
        this.typeBlog = typeBlog;
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

    public String getTypeBlog() {
        return typeBlog;
    }

    public void setTypeBlog(String typeBlog) {
        this.typeBlog = typeBlog;
    }

}
