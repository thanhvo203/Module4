package com.example.demo.service.impl;

import com.example.demo.model.BLog;
import com.example.demo.respository.IBlogRepository;
import com.example.demo.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BlogServiceImpl implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;
    @Override
    public List<BLog> getListBlog() {
        return blogRepository.findAll();
    }

    @Override
    public void createBlog(BLog bLog) {
        blogRepository.save(bLog);
    }

    @Override
    public void deleteBlog(int id) {
        blogRepository.deleteById(id);
    }

    @Override
    public void updateBlog(BLog bLog) {
        blogRepository.save(bLog);
    }

    @Override
    public BLog getBlogByID(int id) {
        return blogRepository.findById(id).orElse(null);
    }
}
