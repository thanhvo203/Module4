package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table (name = "type_blog")
public class TypeBlog {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int id;
    private String typeBlog;

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
