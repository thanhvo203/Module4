package com.example.demo.service;

import com.example.demo.model.TypeBlog;

import java.util.List;

public interface ITypeBlogService {
    List<TypeBlog> findAllByCheckStatusIsFalse();
    void createTypeBlog (TypeBlog typeBlog);
    void deleteTypeBlog (int id);
    void updateTypeBlog(TypeBlog typeBlog);

    TypeBlog detailTypeBlog(int id);

    TypeBlog getTypeBlogById(int id);
}
