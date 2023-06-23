package com.example.demo.service.impl;

import com.example.demo.model.BLog;
import com.example.demo.model.TypeBlog;
import com.example.demo.respository.IBlogRepository;
import com.example.demo.respository.ITypeBlogRepository;
import com.example.demo.service.IBlogService;
import com.example.demo.service.ITypeBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeBlogServiceImpl implements ITypeBlogService {
    @Autowired
    private ITypeBlogRepository typeBlogRepository;

    @Override
    public List<TypeBlog> getListBlog() {
        return typeBlogRepository.findAll();
    }
}

