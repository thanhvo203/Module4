package com.example.demo.respository;

import com.example.demo.model.BLog;
import com.example.demo.model.TypeBlog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITypeBlogRepository extends JpaRepository<TypeBlog,Integer> {
    Page<TypeBlog> findAllByCheckStatusIsFalse (Pageable pageable);
}
