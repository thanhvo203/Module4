package com.example.demo.respository;

import com.example.demo.model.BLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBlogRepository extends JpaRepository<BLog,Integer> {
}
