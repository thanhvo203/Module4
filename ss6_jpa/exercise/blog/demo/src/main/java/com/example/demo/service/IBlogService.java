package com.example.demo.service;

import com.example.demo.model.BLog;

import java.util.List;

public interface IBlogService {
    List<BLog> getListBlog();
    void createBlog (BLog bLog);
    void deleteBlog (int id);
    void updateBlog(BLog bLog);

    BLog getBlogByID(int id);
}
