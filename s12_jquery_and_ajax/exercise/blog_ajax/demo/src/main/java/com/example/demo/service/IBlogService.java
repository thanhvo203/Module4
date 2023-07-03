package com.example.demo.service;

import com.example.demo.model.BLog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogService {
    void createBlog (BLog bLog);
    void deleteBlog (int id);
    void updateBlog(BLog bLog);

    List<BLog> findAllByCheckStatusIsFalse();
    BLog detailBlog(int id);

    BLog getBlogById(int id);

    List<BLog> getBlogByName (String name);

    List<BLog> moreList( int more);


}
