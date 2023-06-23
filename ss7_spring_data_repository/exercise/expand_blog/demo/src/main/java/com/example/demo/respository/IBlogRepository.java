package com.example.demo.respository;

import com.example.demo.model.BLog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBlogRepository extends JpaRepository<BLog,Integer> {
    Page<BLog> findAllByCheckStatusIsFalse(Pageable pageable);
    Page<BLog> findAllByTypeBlogIdAndCheckStatusIsFalse(int id,Pageable pageable);
}
