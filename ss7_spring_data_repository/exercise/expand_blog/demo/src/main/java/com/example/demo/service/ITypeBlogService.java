package com.example.demo.service;

import com.example.demo.model.BLog;
import com.example.demo.model.TypeBlog;

import java.util.List;

public interface ITypeBlogService {
    List<TypeBlog> getListBlog();
    void createTypeBlog (TypeBlog typeBlog);
    void deleteTypeBlog (int id);
    void updateTypeBlog(TypeBlog typeBlog);

    TypeBlog getTypeBlogByID(int id);
}
