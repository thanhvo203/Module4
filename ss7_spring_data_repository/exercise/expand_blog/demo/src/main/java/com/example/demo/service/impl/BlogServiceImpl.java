package com.example.demo.service.impl;

import com.example.demo.model.BLog;
import com.example.demo.respository.IBlogRepository;
import com.example.demo.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BlogServiceImpl implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public void createBlog(BLog bLog) {
        blogRepository.save(bLog);
    }

    @Override
    public void deleteBlog(int id) {
       BLog bLog = getBlogByID(id);
       bLog.setCheckStatus(true);
       blogRepository.save(bLog);
    }

    @Override
    public void updateBlog(BLog bLog) {
        blogRepository.save(bLog);
    }

    @Override
    public BLog getBlogByID(int id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public Page<BLog> searchTypeBlogById(int id, Pageable pageable) {
        return blogRepository.findAllByTypeBlogIdAndCheckStatusIsFalse(id,pageable);
    }

}
